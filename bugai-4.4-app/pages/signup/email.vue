<!-- 注册页 -->
<template>
	<view class="content" :style="{height:screenHeight+'px'}">
		<image class="title" src="../../static/signup.png" mode="aspectFit"></image>
		<view class="content2">
			<input class="in" placeholder="邮箱号" v-model="signForm.email" onkeypress="javascript:if(event.keyCode == 32)event.returnValue = false;">
			<input class="in" placeholder="验证码" v-model="signForm.code" onkeypress="javascript:if(event.keyCode == 32)event.returnValue = false;">
			<button class="bt1" :disabled="disabled" @click="getEmailCode()">{{codeMessage}}</button>
			<button class="bt2" @click="loginCheck()">绑定邮箱</button>
		</view>
	</view>
</template>
<script>
	export default{
		data(){
			return{
				disabled: false,//false启用获取验证码
				signForm:{
					email: "",
					code: ""
					},
				codeMessage: "获取验证码",
				screenHeight: uni.getSystemInfoSync().windowHeight
			}
		},
		methods: {
			goto(url) {
				uni.navigateTo({
					url:url
				})
			},
			getEmailCode(){
				//邮箱验证
				let email_reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
				if(!email_reg.test(this.signForm.email)){
					/*提示代码 邮箱格式错误*/
					uni.showToast({
						title: '邮箱格式错误！',
						icon: 'error',
						duration: 2000
					})
				}else{
					var that = this
					//先检查是否已经注册了
					this.request({
						url: "/email/register",
						method: "POST",
						data: that.signForm
					}).then(resp=>{
						console.log("检查是否注册过")
						console.log(resp)
						//code == 200说明没有注册过，并获取了验证码 或者验证码未过期
						if(resp.code == 200){
							uni.showToast({
							    icon: 'none',
								position: 'bottom',
							    title: resp.msg
							});
							that.disabled = true
							that.codeMessage = 30
							let timer = setInterval(() => {
								that.codeMessage--;
								if (that.codeMessage < 0) {
									clearInterval(timer)
									that.disabled = false
									that.codeMessage = "获取验证码"
								}
							}, 1000)
							//获取验证码倒计时
							setTimeout(function(){
								
								uni.showToast({
								    icon: 'none',
									position: 'bottom',
								    title: '倒计时结束！'
								});
							},30000)
						}else{
							uni.showToast({
							    icon: 'none',
								position: 'bottom',
							    title: resp.msg
							});
						}
						
					})
				}
			},
			loginCheck(){
				var that = this
				//邮箱验证
				let email_reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
				//处理空值问题
				if(
				this.signForm.code == null || this.signForm.code == ""
				){
					uni.showToast({
						title: '输入为空！',
						icon: 'error',
						duration: 2000
					})
				}else if(!email_reg.test(this.signForm.email)){
					/*提示代码 邮箱格式错误*/ 
					uni.showToast({
						title: '邮箱格式错误！',
						icon: 'error',
						duration: 2000
					})
				}
				else{
					//调用方法，向java后端发起请求
					this.signUp(that)
				}
			},
			signUp(that){
				this.request({
					url: "/user/emailBind",
					method: "POST",
					data: that.signForm
				}).then(resp=>{
					console.log("注册")
					console.log(resp)
					if(resp.code == 200){
						//注册成功
						uni.showToast({
							title: '绑定成功！',
							icon: 'none',
							duration: 2000,
						})
						uni.navigateBack()
					}else{
						//注册失败
						uni.showToast({
							title: resp.msg,
							icon: 'none',
							duration: 2000,
						})
					}
				})
			},
			
		}
	}
</script>
<style>
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
		background-color: #4756DF;
		color:#4756DF;
	}
	.content2 {
		width: 300px;
		height: 350px;
		border-radius: 15px;
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
		background-color: #ffffff;
		color:#4756DF;
	}
	.in{
			margin: 10px;
			width: 247px;
			height: 46px;
			text-align:center;
			border:1px solid #c8cccf;
			color:#6a6f77;
			font-size: 15px;
			line-height: 35px;
			border-radius: 10px;
		}
	.bt1{
			margin: 5px;
			margin-top: 8px;
			width: 120px;
			height: 40px;
			background-color: #fb5555;
			color: #ffffff;
			font-size: 14px;
			line-height: 35px;
			border-radius: 8px;
		}
		.bt2{
				margin: 10px;
				margin-top: 10px;
				margin-bottom: 5px;
				width: 180px;
				height: 40px;
				background-color: #4756df;
				color: #ffffff;
				font-size: 15px;
				line-height: 35px;
				border-radius: 8px;
			}
	.title {
		bottom: 41rpx;
		font-size: 36rpx;
		color: #ffffff;
	}
</style>
