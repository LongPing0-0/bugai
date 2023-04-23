<template>
	<view class="acqui-dynamic-message" :style="setPosition()" v-show="animalType == 1 ? showMessage : true">
		<image :src="messageList[cureentMessageIndex].photo" mode="aspectFill" class="user_photo"></image>
		<text>{{ messageList[cureentMessageIndex].text }}</text>
	</view>
</template>

<script>
export default {
	name: 'acqui-dynamic-message',
	props: {
		animalType: {
			//动画类型 0 一直显示 1 闪烁  注意如果是0 切换时长=显示时长+隐藏时长
			type: Number|String,
			default: 1
		},
		showTime: {
			//显示时长，单位s
			type: Number,
			default: 3
		},
		hideTime: {
			//隐藏时长，单位s
			type: Number,
			default: 2
		},
		startShowMessageTime: {
			//第一次显示的时间是多少秒后 0表示立即显示，单位s
			type: Number,
			default: 0
		},
		messagePosition: {
			//信息位置：leftTop 左上  rightTop 右上   bottomLeft 左下   bottomRight 右下
			type: String,
			default: 'leftTop'
		},
		messageCusPosition: {
			//自定义信息位置(优先) 直接写位置信息 如 "left:100rpx;top:200rpx" ...
			type: String
		},
		isFixed:{
			// 是否固定位置
			type:Boolean,
		},
		messageList: {
			//消息列表
			type: Array,
			default() {
				return [
					{
						photo: '/static/BasicsBg.png', //用户头像
						text: '你家的小猪🐖 2小时前给出了五星好评 !' //文本
					},
					{
						photo: '/static/BasicsBg.png', //用户头像
						text: '你家的小猪🐖 2小时前给出了五星好评 !222' //文本
					},
					{
						photo: '/static/BasicsBg.png', //用户头像
						text: '你家的小猪🐖 2小时前给出了五星好评 !3333' //文本
					},
					{
						photo: '/static/BasicsBg.png', //用户头像
						text: '你家的小猪🐖 2小时前给出了五星好评 !444' //文本
					},
					{
						photo: '/static/BasicsBg.png', //用户头像5
						text: '你家的小猪🐖 2小时前给出了五星好评 !555' //文本
					}
				];
			}
		}
	},
	data() {
		return {
			showMessage: false,
			timer: null,
			defaltPositionInfo: {
				leftTop: {
					top: '200rpx',
					left: '10rpx'
				},
				rightTop: {
					top: '200rpx',
					right: '10rpx'
				},
				bottomLeft: {
					bottom: '200rpx',
					left: '10rpx'
				},
				bottomRight: {
					bottom: '200rpx',
					right: '10rpx'
				}
			},
			cureentMessageIndex: 0
		};
	},
	mounted() {
		const timer = setTimeout(() => {
			clearTimeout(timer);
			this.showMessage = true;
			this.mountAnimal();
		}, this.startShowMessageTime * 1000);
	},
	methods: {
		setPosition() {
			if (this.messageCusPosition) return this.messageCusPosition+(this.isFixed&&';position:fixed;');
			else {
				const obj={...this.defaltPositionInfo[this.messagePosition]}
				if(this.isFixed) obj.position='fixed'
				return obj
			};
		},
		mountAnimal() {
			let time = 0;
			this.timer = setInterval(() => {
				++time;
				if (this.showMessage && time >= this.showTime) {
					// 隐藏
					time = 0;
					this.showMessage = false;
				} else if (!this.showMessage && time >= this.hideTime) {
					// 显示
					if (this.cureentMessageIndex < this.messageList.length - 1) ++this.cureentMessageIndex;
					else this.cureentMessageIndex = 0;
					time = 0;
					this.showMessage = true;
				}
			}, 1000);
		}
	},
	beforeDestroy() {
		clearInterval(this.timer);
	}
};
</script>

<style lang="less" scoped>
.acqui-dynamic-message {
	position: absolute;
	z-index: 10;
	background-color: rgba(0, 0, 0, 0.8);
	border-radius: 10rpx;
	color: white;
	padding: 10rpx;
	padding-right: 20rpx;
	font-size: 20rpx;
	display: flex;
	align-items: center;
	.user_photo {
		width: 50rpx;
		height: 50rpx;
		margin-right: 20rpx;
		border-radius: 50%;
	}
}
</style>
