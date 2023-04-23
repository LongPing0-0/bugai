<template>
	<view>
		<acqui-dynamic-message
			ref="dynamicMessage"
			:showTime="parseFloat(showTime) || 3"
			:hideTime="parseFloat(hideTime) || 2"
			:messagePosition="messagePosition"
			:animalType="animalType"
			:messageCusPosition="messageCusPosition"
			:messageList="messageList"
			:isFixed="isFixed"
		></acqui-dynamic-message>
	</view>
</template>

<script>
	export default {
		data() {
			return {
			showTime: 3,
			hideTime: 10,
			messagePosition: 'leftTop',
			animalType: 1,
			messageList: [
				{
					photo: '/static/1024x1024.png', //用户头像
					text: '欢迎使用补概app！😀😀' //文本
				}
			],
			messageCusPosition: '',
			isFixed: false
			};
		},
		onLoad: function(options) {
			setTimeout(function() {
				console.log('start pulldown');
			}, 1000);
			uni.startPullDownRefresh();
		},
		onPullDownRefresh() {
			console.log("下拉刷新")

			setTimeout(function() {
				uni.stopPullDownRefresh();
			}, 1000);
		},
		onReachBottom() {
			console.log("上拉触底")
			this.isChudi = true
		},
		methods: {
			IsCard(e) {
				this.isCard = e.detail.value
			},
		}
	}
</script>

<style>

</style>