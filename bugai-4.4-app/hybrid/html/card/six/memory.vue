<template>
	<view class="warp">
		<web-view :src="url"></web-view>
	</view>
</template>
<script>
	export default {
		data() {
			return {
				url: '',
			}
		},
		onShow() {
			this.url="index.html"; 
		},
	}
</script>

<style>
</style>