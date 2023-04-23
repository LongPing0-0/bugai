<template>
	<view class="content" :style="{height:screenHeight+'px'}">
		<button class="mod1" @click="goto('/pages/knowledge/history')">
			<view class="wrapper">
					概率论发展史
			</view>	
		</button>
		<button class="mod2" @click="goto('/pages/knowledge/classicalproblem')">
			<view class="wrapper">
					概率论经典问题
			</view>	
		</button>	
	</view>
</template>

<script>
	import localhost from '@/common/base.js'
	export default {
		data() {
			return {
				screenHeight: uni.getSystemInfoSync().windowHeight,
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
		display: flex;
		flex-direction: column;
		align-items: center;
		/* justify-content: center; */
		background-image: url('@/static/background.jpg');
		background-color: #aaffff;
		color: #ffffff;
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
		left: 0;
		font-family: 思源黑体 Medium;
		font-weight: 700;
		font-size: 30px;
	}

	.mod1 {
		background-color: rgba(255,255,255, 0.8);
		color: #352b84;
		top: 10%;
		/* margin-left: 5%; */
		margin-bottom: 5%;
		/* width: 337px; */
		width: 100%;
		height: 25%;
		/* border-radius: 15px; */
	}
	.mod2 {
		background-color: rgba(255,255,255, 0.8);
		color: #352b84;
		top: 10%;
		/* margin-left: 5%; */
		/* margin-bottom: 15%; */
		width: 100%;
		height: 25%;
		/* border-radius: 15px; */
	}
</style>
