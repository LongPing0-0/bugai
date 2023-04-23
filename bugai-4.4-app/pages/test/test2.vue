<template>
	<view>
		<cu-custom bgColor="bg-gradual-pink" :isBack="true">
			<block slot="backText">返回</block>
			<block slot="content">动态信息</block>
		</cu-custom>
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

		<image src="https://i.imgtg.com/2023/01/13/QFz3a.jpg" mode="widthFix" style="width: 100%;"></image>

		<view class="cu-bar margin-top bg-white">
			<view class="action">
				<text class="cuIcon-title text-blue"></text>
				显示位置
			</view>
		</view>
		<view class="action bg-white" style="padding-bottom: 30rpx;">
			<radio-group @change="changeShowPosition">
				<label>
					<radio class="blue radio" value="leftTop" checked></radio>
					<text class="margin-left-sm">左上</text>
				</label>
				<label class="margin-left-sm">
					<radio class="blue radio" value="rightTop"></radio>
					<text class="margin-left-sm">右上</text>
				</label>
				<label class="margin-left-sm">
					<radio class="blue radio" value="bottomLeft"></radio>
					<text class="margin-left-sm">左下</text>
				</label>
				<label class="margin-left-sm">
					<radio class="blue radio" value="bottomRight"></radio>
					<text class="margin-left-sm">右下</text>
				</label>
			</radio-group>
			<view class="flex align-center" style="margin-left: 30rpx;margin-top: 30rpx;">
				<text>自定义:</text>
				<input
					type="text"
					v-model="messageCusPosition"
					placeholder="样式代码:如 left:30rpx;top:100rpx;"
					style="border-bottom: 1px solid;margin-left: 30rpx;text-align: center;"
					placeholder-style="font-size:18rpx"
				/>
			</view>
		</view>

		<view class="cu-bar margin-top bg-white">
			<view class="action">
				<text class="cuIcon-title text-blue"></text>
				显示方式
			</view>
		</view>
		<view class="action bg-white" style="padding-bottom: 30rpx;">
			<radio-group @change="changeShowMeth">
				<label>
					<radio class="blue radio" value="" checked></radio>
					<text class="margin-left-sm">默认</text>
				</label>
				<label class="margin-left-sm">
					<radio class="blue radio" value="true"></radio>
					<text class="margin-left-sm">固定</text>
				</label>
			</radio-group>
		</view>

		<view class="cu-bar margin-top bg-white">
			<view class="action">
				<text class="cuIcon-title text-blue"></text>
				动画类型
			</view>
		</view>
		<view class="action bg-white" style="padding-bottom: 30rpx;">
			<radio-group @change="changeAnimalType">
				<label>
					<radio class="blue radio" value="1" checked></radio>
					<text class="margin-left-sm">闪烁</text>
				</label>
				<label class="margin-left-sm">
					<radio class="blue radio" value="0"></radio>
					<text class="margin-left-sm">一直显示</text>
				</label>
			</radio-group>
		</view>

		<view class="cu-bar margin-top bg-white">
			<view class="action">
				<text class="cuIcon-title text-blue"></text>
				时长设置
			</view>
		</view>
		<view class="action bg-white flex justify-between align-center" style="padding-bottom: 30rpx;padding-right: 30rpx;">
			<view class="flex align-center input_continor">
				<text>显示时长:</text>
				<input v-model="showTime" type="number" />
				s
			</view>
			<view class="flex align-center input_continor">
				<text>隐藏时长:</text>
				<input v-model="hideTime" type="number" />
				s
			</view>
		</view>
	</view>
</template>

<script>
export default {
	data() {
		return {
			showTime: 3,
			hideTime: 2,
			messagePosition: 'leftTop',
			animalType: 1,
			messageList: [
				{
					photo: '/static/BasicsBg.png', //用户头像
					text: '你家的小猪🐖 2小时前给出了五星好评 !' //文本
				},
				{
					photo: '/static/BasicsBg.png', //用户头像
					text: '小媛媛5小时前给出了五星好评 !' //文本
				},
				{
					photo: '/static/BasicsBg.png', //用户头像
					text: '老麻2小时前拼单成功 !' //文本
				},
				{
					photo: '/static/BasicsBg.png', //用户头像
					text: '用户迟到的春天刚刚下单成功 !' //文本
				}
			],
			messageCusPosition: '',
			isFixed: false
		};
	},
	methods: {
		changeShowPosition(e) {
			this.messagePosition = e.target.value;
		},
		changeAnimalType(e) {
			this.animalType = e.target.value;
		},
		changeShowMeth(e) {
			this.isFixed = Boolean(e.target.value);
			// 这里做演示需要动态切换显示方式 需要去手动刷新
			this.$refs.dynamicMessage.setPosition();
		}
	}
};
</script>

<style lang="less">
page {
	background-color: #f1f1f1;
}
radio-group {
	padding-left: 30rpx;
}
radio {
	transform: scale(0.8);
}
.input_continor {
	padding-left: 30rpx;
	input {
		border-bottom: 1px solid;
		margin-left: 30rpx;
		max-width: 100rpx;
		text-align: center;
	}
}
</style>
