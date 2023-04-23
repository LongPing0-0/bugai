<!-- 记忆卡片页面 -->
<template>
	<view class="content" :style="{height:screenHeight+'px'}">
		<button class="mod1" @click="goto('/pages/HtmlCard/one')">
			<image src="../../static/in.png"  class="jpg"></image>
				<view class="text">第一章 随机事件及其运算</view>
				<!-- <view class="taxt2">随机变量及其分布</view> -->
			</button>
			<button class="mod1" @click="goto('/pages/HtmlCard/two')">
				<image src="../../static/in.png"  class="jpg"></image>
				<view class="text">
					第二章 随机变量及其分布
				</view>
			</button>
			<button class="mod1" @click="goto('/pages/HtmlCard/three')">
				<image src="../../static/in.png"  class="jpg"></image>
				<view class="text">
					第三章 多维随机变量及其联合分布
				</view>
			</button>
			<button class="mod1" @click="goto('/pages/HtmlCard/four')">
				<image src="../../static/in.png"  class="jpg"></image>
				<view class="text">
					第四章 大数定律与中心极限定理
				</view>
			</button>
			<button class="mod1" @click="goto('/pages/HtmlCard/five')">
				<image src="../../static/in.png"  class="jpg"></image>
				<view class="text">
					第五章 统计量及其分布
				</view>
			</button>
			<button class="mod1 flex-con" @click="goto('/pages/HtmlCard/six')">
				<image src="../../static/in.png"  class="jpg"></image>
				<view class="text">
					第六章 参数估计
				</view>
			</button>
			<button class="mod1 flex-con" @click="goto('/pages/HtmlCard/seven')">
				<image src="../../static/in.png"  class="jpg"></image>
				<view class="text">
					第七章 假设检验
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
		background-image:url("@/static/card22.png");
		background-color: #1650ff;
	    background-size: 100% 120%;
		display: flex;
		flex-direction: column;
 		text-align: center;
		align-items: center;
		min-height: 100%;
	}

	.text{
		margin-left: 5px;
		float: left;
		padding: 25px 0;
		font-size:large;
		color: #ffffff;
		font-weight: 500;
		
	}
	
	.text2{
		margin-left: 3px;
		float: left;
		padding: 20px 0;
		font-size:medium;
		font-weight: bold;
		
	}
	
	.mod1 {
		top: 0%;
		width: 100%;
		height: 100px;
		background-color: rgba(255, 255, 255, 0.3);
		flex: 0 0 100px;
		flex-shrink:0
	}
	
	.jpg {
		float: right;
		top:30px;
		bottom: 10px;
		width: 40px;
		height: 40px;
	}
</style>
