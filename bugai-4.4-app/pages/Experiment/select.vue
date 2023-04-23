<template>
	<view class="content" :style="{height:screenHeight+'px'}">
		<view class="backcolor"></view>
		<button class="mod1" @click="goto('/pages/Experiment/ch1')">
			<image src="../../static/lab/1-1.png" class="jpg"></image>
			<view>
				实验一 <nav>随机实验与概率</nav>
			</view>
		</button>
		<button class="mod1" @click="goto('/pages/Experiment/ch3')">
			<image src="../../static/lab/1-3.png" class="jpg"></image>
			<view>
				实验二 <nav>期望与方差</nav>
			</view>
		</button>
		<button class="mod1" @click="goto('/pages/Experiment/ch4')">
			<image src="../../static/lab/2-1.png" class="jpg"></image>
			<view>
				实验三 <nav>事件运算关系</nav>
			</view>
		</button>
		
		<!-- 实验四（龙平放进去） -->
		<button class="mod1" @click="goto('/pages/HtmlCard/touzheng')">
			<image src="../../static/lab/3-1.png" class="jpg"></image>
			<view>
				实验四 <nav>浦丰投针实验</nav>
			</view>
		</button>
		
		<!-- 实验五（龙平放进去） -->
		<button class="mod1" @click="goto('/pages/Experiment/ch6')">
			<image src="../../static/lab/3-3.png" class="jpg"></image>
			<view>
				实验五 <nav>二项分布</nav>
			</view>
		</button>
		
		<button class="mod1" @click="goto('/pages/HtmlCard/bosongfenbu')">
			<image src="../../static/lab/4-3.png" class="jpg"></image>
			<view>
				实验六 <nav>泊松分布</nav>
			</view>
		</button>
		
		<!-- 实验七(龙平放进去) -->
		<button class="mod1" @click="goto('/pages/Experiment/ch8')">
			<image src="../../static/lab/2-3.png" class="jpg"></image>
			<view>
				实验七 <nav>正态分布</nav>
			</view>
		</button>
		
		<button class="mod1" @click="goto('/pages/Experiment/ch8_p')">
			<image src="../../static/lab/4-1.png" class="jpg"></image>
			<view>
				实验八 <nav>点估计</nav>
			</view>
		</button>
		
<!-- 		<button class="mod1" @click="goto('/pages/Experiment/ch9')">
			<image src="../../static/lab/5-2.png" class="jpg"></image>
			<view>
				实验九 <nav>置信区间问题1</nav>
			</view>
		</button> -->

		<!-- 谭学轩新做的那个，还有问题，梁先挖个空，后面再填 -->
		<button class="mod1" @click="goto('/pages/Experiment/ch10')">
			<image src="../../static/lab/5-3.png" class="jpg"></image>
			<view>
				实验九 <nav>置信区间问题</nav>
			</view>
		</button>
<!-- 		<button class="mod1" @click="goto('/pages/Experiment/ch11')">
			<image src="../../static/lab/4-2.png" class="jpg"></image>
			<view>
				实验十 <nav>保险公司盈利问题</nav>
			</view>
		</button> -->
		<button class="mod1" @click="goto('/pages/Experiment/ch12')">
			<image src="../../static/lab/6-3.png" class="jpg"></image>
			<view>
				实验十 <nav>生日问题</nav>
			</view>
		</button>
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
		text-align: center;
		align-items: center; 
		min-height: 100%;
	}
	.backcolor{
		position: fixed;
		top: 0;
		left: 0;
		right: 0;
		bottom: 0;
		background-color: #30242a;
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
		color: #ffffff;
		font-family: 思源黑体 Medium;
		font-weight: 800;
		font-size: 18px;
		justify-content: center;
		align-items: center;
	}

	.mod1 {
		margin: 2%;
		width: 90%;
		height: 100px;
		justify-content: center;
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
