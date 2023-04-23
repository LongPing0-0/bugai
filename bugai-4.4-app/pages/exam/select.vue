<template>
	<view class="content" :style="{height:screenHeight+'px'}">
		<button class="mod1" @click="goto('/pages/Experiment/ch1')">
			<view>
				第一章 <nav>随机事件与概率</nav>
				
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
		background-image:url("");
		background-color: "#ffffff";
		display: flex;
		flex-direction: column;
		text-align: center;
		align-items: center; 
		min-height: 100%;
		color: "#ffffff";
	}

	.mod1 {
		margin: 2%;
		width: 100%;
		height: 100px;
		/* background-color: aquamarine; */
		background-color: rgba(255, 255, 255, 0.3);
		border-radius: 8px;
		flex: 0 0 100px;
		flex-shrink:0
	}
	
</style>
