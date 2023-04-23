<template>
	<view>
			<view v-for="(item,index) in dataList">
				<view class="enl-log-box">
					<view class="title">{{item.version}}（版本）</view>
					<view class="date">{{item.created}}</view>
					<view class="manages">
						<text>{{item.content}}</text>
					</view>
				</view>
			</view>

	</view>
</template>

<script>
export default {
	data() {
		return {
			dataList: []
		};
	},
	onPullDownRefresh() {
		//下拉刷新uniCloud表

	},
	mounted() {
		this.getUpdateInfo()
	},
	methods: {
		getUpdateInfo(){
			console.log("获取更新日志")
			this.request({
				url: "/app/allUpdateInfo",
				method: "POST",
				data:{
					  currentPage: 1,
					  size: 10
				}
			}).then(resp=>{
				console.log(resp)
				if(resp.code == 200){
					this.dataList = resp.data.data
				}
			})
		}
	}
};
</script>

<style lang="scss">
.enl-log-box {
	margin: 30rpx;
	padding: 20rpx;
	background: #ffffff;
	box-shadow: 0px 4rpx 20rpx rgba(137, 143, 155, 0.2);
	border-radius: 16rpx;
	line-height: 40rpx;

	.title {
		font-size: 34rpx;
		font-weight: 400;
		color: #333333;
	}
	.date {
		font-size: 24rpx;
		font-weight: 400;
		color: #999999;
	}
	.manages {
		margin: 10rpx 0 0;
		padding: 20rpx;
		background: #f1f1f1;
		border-radius: 14rpx;
		font-size: 24rpx;
		font-weight: 400;
		color: #666666;
	}
}
.add-float {
	position: fixed;
	bottom: 30rpx;
	right: 30rpx;
	z-index: 99;
	.iconSize {
		font-size: 60rpx;
	}
}
</style>
