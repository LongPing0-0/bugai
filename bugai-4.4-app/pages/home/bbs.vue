<template>
	<view class="content" :style="{height:screenHeight+'px'}">
		<div class="mod1" id="index">
		     <TemFoot></TemFoot>
		</div>
		<view class="mod1" @click="goto('/pages/luntan/luntan')">\
			<luntan></luntan>
			<!-- <image src="../../static/imgs/jiaoliuluntanfengmian.png"></image> -->
		</view>
		<div class="mod1" id="index">
		     <TemHead></TemHead>
		</div>
	</view>
</template>

<script>
	import luntan from "@/pages/home/luntan.vue"
	import TemFoot from '../lunbotu/lunbotu.vue'
	import TemHead from '../home/guanggao.vue'
	import localhost from '@/common/base.js'
	export default {
		name: 'index',
		data() {
			return {
				screenHeight: uni.getSystemInfoSync().windowHeight,
			}
		},
		onLoad() {
			console.log(localhost.localhost);
		},
		components:{
		  TemFoot,
		  TemHead,
		  luntan
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

		background-color: rgb(71,86,223);
		color: #421d87;
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
		font-size: 20px;
		justify-content: center;
		align-items: center;
	}

	.mod1 {
		top: 5%;
		margin: 5%;
		width: 85%;
		height: 35%;
		border-radius: 15px;
	}
	.mod2 {
		background-color: darkgray;
		margin: 5%;
		margin-left: 5%;
		width: 85%;
		height: 35%;
		border-radius: 15px;
	}
	.mod3 {
		margin: 5%;
		margin-left: 5%;
		width: 85%;
		height: 35%;
		border-radius: 15px;
	}
</style>
