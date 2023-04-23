<template>
	<view class="content" :style="{height:screenHeight+'px'}">
		<image class="title" src="../../static/signup.png" mode="aspectFit"></image>
		<view class="content2">
			<input class="in" password="true" placeholder="设置新密码" v-model="forgetForm.password" onkeypress="javascript:if(event.keyCode == 32)event.returnValue = false;">
			<input class="in" placeholder="邮箱号" v-model="forgetForm.email" onkeypress="javascript:if(event.keyCode == 32)event.returnValue = false;">
			<input class="in" placeholder="验证码" v-model="forgetForm.code" onkeypress="javascript:if(event.keyCode == 32)event.returnValue = false;">
			<button class="bt1" :disabled="disabled" @click="getEmailCode()">{{codeMessage}}</button>
			<button class="bt2" @click="forgetCheck()">确认找回</button>
<!-- 			<button class="bt2" plain="true" @click="goto('/pages/signup/login')">已经有一个账号</button> -->
		</view>
	</view>
	
</template>

<script>
	export default{
		data(){
			return{
				forgetForm:{
					code: "",
					email: "",
					password: ""
				},
				disabled: false,//false启用获取验证码
				codeMessage: "获取验证码",
				screenHeight: uni.getSystemInfoSync().windowHeight
			}
		},
		methods: {
			getEmailCode(){
				//邮箱验证
				var that = this
				let email_reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
				if(!email_reg.test(this.forgetForm.email)){
					/*提示代码 邮箱格式错误*/
					uni.showToast({
						title: '邮箱格式错误！',
						icon: 'error',
						duration: 2000
					})
				}else{
					this.request({
						url: "/email/forget",
						method: "POST",
						data: that.forgetForm
					}).then(resp=>{
						console.log(resp)
						if(resp.code == 200){
							//发送成功
							uni.showToast({
							    icon: 'none',
								position: 'bottom',
							    title: resp.msg
							});
							//倒计时
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
						}
					})
				}
			},
			forgetCheck(){
				//邮箱验证
				let email_reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
				//处理空值问题
				if(
				this.forgetForm.code == null || this.forgetForm.code == ""
				){
					uni.showToast({
						title: '输入为空！',
						icon: 'error',
						duration: 2000
					})
				}else if(!email_reg.test(this.forgetForm.email)){
					/*提示代码 邮箱格式错误*/ 
					uni.showToast({
						title: '邮箱格式错误！',
						icon: 'error',
						duration: 2000
					})
				}
				else{
					//调用方法，向java后端发起请求
					this.forget()
				}
			},
			forget(){
				var that = this
				this.request({
					url: "/user/forget",
					method: "POST",
					data: that.forgetForm
				}).then(resp=>{
					console.log("添加用户")
					console.log(resp)
					if(resp.code == 200){
						//找回成功
						uni.showToast({
							title: '找回成功！',
							icon: 'success',
							duration: 2000,
						})
						setTimeout(function(){
							uni.navigateTo({
								url: 'login'
							})
						},2000)
					}else{
						//注册失败
						uni.showToast({
							title: resp.msg,
							icon: 'error',
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
		height: 360px;
		border-radius: 5px;
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
			font-size: 12px;
			line-height: 35px;
			border-radius: 8px;
		}
	.bt1{
			margin: 5px;
			margin-top: 15px;
			width: 100px;
			height: 35px;
			background-color: #fb5555;
			color: #ffffff;
			font-size: 14px;
			line-height: 35px;
			border-radius: 8px;
		}
		.bt2{
				margin: 5px;
				margin-top: 15px;
				margin-bottom: 8px;
				width: 140px;
				height: 35px;
				background-color: #FFBE21;
				color: #ffffff;
				font-size: 14px;
				line-height: 35px;
				border-radius: 8px;
			}

	.title {
		bottom: 41rpx;
		font-size: 36rpx;
		color: #ffffff;
	}
</style>
