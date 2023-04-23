<template>
	<view>
		<view class="content">
			<view class="jo-logo-box">
				<image class="jo-logo" src="/static/1024x1024.png"></image>
				<view class="flex flex-column">
					<text class="title">BUIGAI-{{newVersion}}</text>
					<text class="version">当前版本：{{ version || '1.0.0' }}{{checkContent}}</text>
				</view>
			</view>
			<view class="jo-list" @click="goUpdateLog" hover-class="contentHover" hover-stay-time="50">
				<view class="list-text">更新日志</view>
				<view class="cuIcon-right list-icon"></view>
			</view>
			<!-- 可删去  开发者下，可编辑增删改查日志内容 -->
			<view class="cu-bar margin-top bg-white solid-bottom">
				<view class="action">
					<text class="cuIcon-title text-blue"></text>
					切换为开发者/游客
				</view>
			</view>
			<view class="padding flex flex-wrap justify-around align-center bg-white">
				<!-- <button class="cu-btn round" @click="isDeveloper">开发者:增删改查日志</button> -->
				<button class="cu-btn round" @click="unDeveloper">游客:仅预览日志</button>
			</view>
		</view>
		<view class="footer">
			<view class="footer_pri">
				<view class="flex" @click="">隐私声明</view>
				<view class="linecenter">|</view>
				<view class="flex" @click="">服务条款</view>
			</view>
			<view class="footer_Copyright">{{ copyrightInfor }}</view>
		</view>
	</view>
</template>
<script>
export default {
	data() {
		return {
			checkContent: "(旧版本)",
			copyrightInfor: `©${new Date().getFullYear()} 补概App`,
			version: '',
			versionCode: 100,
			newVersion: '1.0.0',
			
		};
	},
	mounted() {
		// #ifdef APP-PLUS
		this.version = plus.runtime.version
		this.versionCode = plus.runtime.versionCode
		//获取manifest.json的版本号
		// plus.runtime.getProperty(plus.runtime.appid, function(wgtInfo) {
		// 	this.version = wgtInfo.version;
		// });
		this.getUpdateInfo()
		// #endif
	},
	methods: {
		getUpdateInfo(){
			this.request({
				url: "/app/checkUpdate",
				method: "POST",
				data:{
					versionCode: 100
				}
			}).then(resp=>{
				if(resp.code != 200){
					return;
				}
				if(this.versionCode == resp.data.versionCode){
					this.checkContent = "(最新版本)"
					this.newVersion = resp.data.version
				}
			})
		},
		isDeveloper() {

			this.goUpdateLog();
		},
		unDeveloper() {

			this.goUpdateLog();
		},
		goUpdateLog() {
			uni.navigateTo({
				url: './updateLoge'
			});
		}
	}
};
</script>

<style lang="scss">
page {
	background-color: #ffffff;
}
.content {
	text-align: center;
	height: calc(86vh);
	display: flex;
	flex-direction: column;
}
.flex-column {
	flex-direction: column;
}

.jo-list {
	display: flex;
	justify-content: space-between;
	margin: 0 30rpx;
	padding: 30rpx 0;
	border-bottom: rgba(213, 213, 213, 0.5) solid 2rpx;

	.list-text {
		font-size: 30rpx;
		color: #3e4049;
	}
	.list-icon {
		font-size: 40rpx;
		color: #dadada;
	}
}

.jo-logo-box {
	margin: 150rpx 0 50rpx 0;
	.jo-logo {
		border-radius: 40rpx;
		width: 200rpx;
		height: 200rpx;
	}
	.title {
		font-size: 36rpx;
		color: #373737;
		font-weight: bold;
		margin: 20rpx 0 10rpx;
	}
	.version {
		font-size: 28upx;
		color: #7e7e83;
		vertical-align: text-top;
		line-height: 40rpx;
	}
}

.footer {
	position: relative;
	text-align: center;
	width: 100%;
	bottom: 0;

	&_pri {
		color: #0f58ff;
		font-size: 22rpx;
		display: flex;
		width: 100%;
		justify-content: center;
		text-decoration: underline;

		.linecenter {
			margin: 0 20rpx;
			margin-top: 5rpx;
		}
	}

	&_Copyright {
		color: #adafb4;
		font-size: 22rpx;
		height: 50rpx;
		line-height: 50rpx;
	}
}
</style>
