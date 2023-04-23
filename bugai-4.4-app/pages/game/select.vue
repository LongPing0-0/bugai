<template>
	<view class="content" :style="{height:screenHeight+'px'}">
		<button class="mod1" @click="goto('/pages/game/g1')">
			<view class="wrapper">
				<image src="../../static/star.png" class="jpg"></image>
				三门问题
			</view>
		</button>
		<button class="mod1" @click="goto('/pages/Experiment/ch5')">
			<view class="wrapper">
				<image src="../../static/star.png" class="jpg"></image>
				排列组合
			</view>
		</button>
		<button class="mod1" @click="goto('/pages/game/g3')">
			<view class="wrapper">
				<image src="../../static/star.png" class="jpg"></image>
				骰子游戏
			</view>
		</button>
	</view>
</template>

<script>
	import localhost from '@/common/base.js'
	import shaizishiyan from "@/components/shaizishiyan/shaizishiyan.vue"
	export default {
		data() {
			return {
				screenHeight: uni.getSystemInfoSync().windowHeight
			}
		},
		onLoad() {
			console.log(localhost.localhost);
		},
		methods: {
			goto(url) {
				uni.navigateTo({
					url: url
				})
			}
			
		}
	}
</script>

<style>
	.content {
		background-image: url("/static/success.png");	
		background-position: center center;/* 背景图垂直、水平均居中 */
		background-repeat: no-repeat;/* 背景图不平铺 */
		background-color: #e5e5e5;
		
	}

	/* CDN 服务仅供平台体验和调试使用，平台不承诺服务的稳定性，企业客户需下载字体包自行发布使用并做好备份。 */
	@font-face {
		font-family: "思源黑体 Medium";
		font-weight: 500;
		src: url("//at.alicdn.com/wf/webfont/ojCJFxjjxpCC/0aJcoky6Dewd6hsO4gJ6g.woff2") format("woff2"),
			url("//at.alicdn.com/wf/webfont/ojCJFxjjxpCC/x5eTfHE3JBd-OG7v0Shez.woff") format("woff");
		font-display: swap;
	}

	.wrapper {
		position: absolute;
		top: 25%;
		right: 0;
		bottom: 0;
		left: 20px;
		color: #4846c2;
		text-shadow: 0 0 4px #ffffff;
		font-family: 思源黑体 Medium;
		font-weight: 800;
		font-size: 30px;
		/* justify-content: center; */
		/* align-items: center; */
	}

	.mod1 {
		top: 10px;
		margin: 5%;
		width: 90%;
		height: 25%;
		background-color: rgba(255, 255, 255, 0.5);
		/* justify-content: center; */
		border-radius: 8px;
		flex: 0 0 100px;
		flex-shrink:0
	}
	.jpg {
		float: left;
		top:10px;
		bottom: 10px;
		width: 80px;
		height: 80px;
	}
</style>
