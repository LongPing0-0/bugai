<template>
<!-- 	<div style="width:100%:height:100%;">
		<iframe src="src" frameborder="0" style="width:100%;height:100%;"></iframe>
	</div>
	<iframe style="width: 100%; height: 800px;" id="tempHtml" ref="tempHtml" frameborder="0"></iframe> -->
 	<view >
		<web-view src="/hybrid/html//jingdianwenti/jingdianwenti.html"></web-view>
	</view>
</template>

<script>
	export default {
		data() {
			// 我的外部文件是temp.html
			return {
				showSessionId:'',
				src:'',
			}
		},
		mounted(){
			this.showSessionId = window.location.search;
			this.src = '/hybrid/html//jingdianwenti/jingdianwenti.html${this.showSessionId}';
		},
	};
</script>

<style>

</style>