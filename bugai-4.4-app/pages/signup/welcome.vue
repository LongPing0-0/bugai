<template>
	<view class="content" :style="{height:screenHeight+'px'}">
		<button class="mod1" @click="goto('/pages/Experiment/select')">
			<view class="wrapper">
					概率论实验可视化
			</view>	
		</button>
		<button size='mini' class="mod2" @click="goto('/pages/game/select')">
			<view class="wrapper">
					概率论趣味游戏
			</view>	
		</button>
		<button size='mini' class="mod3" @click="goto('/pages/knowledge/select')">
			<view class="wrapper">
					知识拓展	
			</view>	
		</button>
		<button class="mod4" @click="goto('/pages/examination/exam_list')">
			<view class="wrapper">
					概率题库
			</view>	
		</button>
		<button class="mod5" @click="goto('/pages/card/select')">
			<view class="wrapper">
					记忆卡片	
			</view>	
		</button>
		
		
		<!-- 测试 -->
		
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
        /* display: flex; */
		/* flex-direction: column; */
		/*justify-content: center;*/
		background-color: #4756df;
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
		top: 30%;
		right: 0;
		bottom: 0;
		left: 0;
		font-family: 思源黑体 Medium;
		font-weight: 800;
		font-size: 20px;
	}

	.mod1 {
		top: 10%;
		margin-left: 5%;
		margin-bottom: 5%;
		background-image: url("@/static/card.png");
		background-size: 337px 164px;
		width: 337px;
		height: 164px;
		border-radius: 15px;
	}
	
	.mod2 {
		margin-top: 15%;
		margin-left: 5%;
		background-image: url("@/static/card2.png");
		background-size: 164px 164px;
		width: 164px;
		height: 164px;
		border-radius: 15px;
	}
	
	.mod3 {
		margin-top: 15%;
		margin-left: 10px;
		margin-right: 5px;
		background-image: url("@/static/card3.png");
		background-size: 164px 164px;
		width: 164px;
		height: 164px;
		border-radius: 15px;
	}
	
	.mod4 {
		margin-top: 1%;
		margin-left: 5%;
		background-color: #FFBE21;
		width: 337px;
		height: 114px;
		border-radius: 15px;
	}
	
	.mod5 {
		margin-top: 5%;
		margin-left: 5%;
		margin-bottom: 6%;
		background-image: url("@/static/card4.png");
		background-size: 337px 144px;
		width: 337px;
		height: 114px;
		border-radius: 15px;
	}
</style>
