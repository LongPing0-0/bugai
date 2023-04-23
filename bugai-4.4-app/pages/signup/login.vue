<template>
	<view class="content" :style="{height:screenHeight+'px'}">
		<image class="title" src="../../static/login.png" mode="aspectFit"></image>
		<view class="content2">
			<input v-model="loginForm.username" class="in" placeholder="User name" onkeypress="javascript:if(event.keyCode == 32)event.returnValue = false;">
			<input v-model="loginForm.password" class="in" password="true" placeholder="Password" onkeypress="javascript:if(event.keyCode == 32)event.returnValue = false;">
			<button class="bt1" @click="login()">登录</button>
			<button class="bt2" @click="goto('/pages/signup/forget')">忘记密码</button>
		</view>		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				loginForm: {
					username: "",
					password: ""
				},
				showPassword: true,
				pwdIcon:"../../static/pwd1.png",
				screenHeight: uni.getSystemInfoSync().windowHeight
			}
		},
		mounted(){
			this.doLogin()
		},
		methods: {
			login(){
				var that = this
				this.request({
					url: "/login",
					method: "POST",
					data: that.loginForm
				}).then(resp=>{
					console.log(resp)
					if(resp.code == 200 && resp.data.token != null){
						//登录成功
						console.log("登录成功")
						//将令牌存入本地缓存
						uni.setStorageSync("JWT","Bearer"+resp.data.token)
						//跳转路由到主页
						console.log("登录后获取")
						console.log(uni.getStorageInfoSync("JWT"))
						uni.switchTab({
							url: 'welcome'
						})
					}
				})
			},
			goto(url) {
				uni.navigateTo({
					url:url
				})
			},
			//预登录
			doLogin(){
				var that = this
				this.request({
					url: "/user/doLogin",
					method: "GET",
				}).then(resp=>{
					console.log(resp)
					if(resp.code == 200){
						//跳转路由到主页
						uni.switchTab({
							url: 'welcome'
						})
					}
				})
			}
		}
	}
</script>

<style>
	.content {
		display: flex;
		height:512px;
		flex-direction: column;
		align-items: center;
		justify-content: center;
		background-color: #4756DF;
		color:#4756DF;
	}
	.content2 {
		width: 300px;
		height: 260px;
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
			//line-height: 35px;
			border-radius: 8px;
		}
	.bt1{
			margin: 5px;
			margin-top: 15px;
			width: 100px;
			height: 35px;
			background-color: #4756df;
			color: #ffffff;
			font-size: 14px;
			line-height: 35px;
			border-radius: 8px;
		}
		.bt2{
				margin: 5px;
				margin-top: 15px;
				width: 100px;
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
