<template>
	<view class="content">
		<web-view class="webview" :src="imp"></web-view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				imp:'/hybrid/html/game/shaizi/shiyan.html'
			}
		},
		methods: {
			
		}
	}
</script>

<style>
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		height: 100vh;
		background-color: #609df8;
		color: #609df8;
	}
	.webview{
		width:100%;
		height: 100%;
	}
</style>
