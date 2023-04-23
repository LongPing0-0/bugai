<template>
	<view class="content" :style="{height:screenHeight+'px'}">
		<image src="../../static/logo.png" mode="aspectFit"></image>
		<!-- <view class="zit">让概率论学习变得有趣</view> -->
		<image class="title" src="../../static/shuju.png" mode="aspectFit"></image>
		<button class="bt1" @click="goto('/pages/signup/signup')">注册账号</button>
		<button class="bt1" @click="goto('/pages/signup/login')">已经有一个账号</button>
		<view >来自西南民族大学数学学院团队</view>
	</view>
</template>

<script>
	import localhost from '@/common/base.js'
	export default {
		data() {
			return {
				screenHeight: uni.getSystemInfoSync().windowHeight
			}
		},
		  onLoad(){  
		    console.log(localhost.localhost);  
		  }, 
		  mounted(){
			this.doLogin()  
		  },
			methods: {
				goto(url) {
					uni.navigateTo({
						url:url
					})
				},
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
		flex-direction: column;
		align-items: center;
		justify-content: center;
		background-color: #aaffff;
		color:#4756DF;
	}

	.bt1{
			margin: 5px;
			width: 247px;
			height: 40px;
			background-color: #FFBE21;
			color: #ffffff;
			font-size: 14px;
			line-height: 35px;
			border-radius: 17px;
		}


	.title {
		margin: 8px;
		bottom: 40rpx;
		font-size: 16px;
		color: #07b6bb;
	}
	@font-face {
		font-family: "思源黑体 Medium";
		font-weight: 500;
		src: url("//at.alicdn.com/wf/webfont/ojCJFxjjxpCC/0aJcoky6Dewd6hsO4gJ6g.woff2") format("woff2"),
			url("//at.alicdn.com/wf/webfont/ojCJFxjjxpCC/x5eTfHE3JBd-OG7v0Shez.woff") format("woff");
		font-display: swap;
	}
	
	.zit {
		position: absolute;
		margin: 6%;
		top: 30%;
		bottom: 0;
		color: #ae312f;
		font-family: 思源黑体 Medium;
		font-weight: 500;
		font-size: 15px;
	}
</style>
