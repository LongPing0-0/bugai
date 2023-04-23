<template>
	<view class="content" :style="{height:screenHeight+'px'}">
		<view style="background-color: #609df8;"></view>
		<view class="mod1">
			<!-- 实验介绍 -->
			假设每人的生日在一年365天的任意一天是等可能的，
			即都等于1/365，求n(<=365)个人中至少有m人生日相同的概率p </view>
				<view class="mod2">
					<!-- 实验部分 -->
					<shengriwenti></shengriwenti>
<!-- 					<button type="primary" plain="true" @click="exp()">开始实验</button>
 -->				</view>
				<view class="mod4">
					<!-- 实验小结 -->
					对于本题，我们需要用到组合数学的知识。我们可以计算出任选m个人生日相同的概率，即为：
					
					P(m)=365×364×⋯×(365−m+1)365mP(m)=365m365×364×⋯×(365−m+1)​
					
					然后我们需要求的是至少有m个人生日相同的概率，即：
					
					p=P(m)+P(m+1)+⋯+P(n)p=P(m)+P(m+1)+⋯+P(n)
					
					其中，n为共有多少人。通过计算不同m和n的取值，我们可以得出在不同的情况下至少有m人生日相同的概率。
<!-- 					<view class="tu">
						<view class="a1">
							<image src="/static/shengri.png" v-show="showImg1"></image>
						</view>
					</view> -->
				</view>
		</view>
</template>

<script>
	import shengriwenti from '@/components/shaizishiyan/shaizishiyan.vue'
	export default {
		data() {
			return {
screenHeight: uni.getSystemInfoSync().windowHeight,
				showImg1: false,
			}
		},
		components(){
			shengriwenti
		},
		methods: {
			exp() {
				this.showImg1 = true

			}
		}
	}
</script>



<style>
	.content {
		display: flex;
		flex-direction: column;
		/* text-align: center; */
		align-items: center;
		background-color: #609df8;
		color: #609df8;
	}

	.mod1 {
		margin: 3px;
		padding: 5px;
		width: 90%;
		background-color: #ffffff;
		float: left;
		justify-content: left;
		border-radius: 5px;
	}

	.mod2 {
		margin: 3px;
		padding: 3px;
		width: 90%;
		/* height: 320px; */
		background-color: #ffffff;
		justify-content: center;
		border-radius: 5px;
	}
	.mod4{
		margin: 3px;
		padding: 3px;
		width: 90%;
		/* height: 320px; */
		background-color: #ffffff;
		justify-content: center;
		border-radius: 5px;
		min-height: 400rpx;
	}
	.mod3 {
		margin: 3px;
		padding: 5px;
		width: 90%;
		height: 500px;
		background-color: #ffffff;
		font-size: 16px;
		font-weight: 500;
		color: black;
		justify-content: center;
		border-radius: 8px;
	}


	.text {
		text-align: center;
		/** 水平居中 **/
		font-weight: 600;
	}

	.tu {
		text-align: center;
		/** 水平居中 **/

	}
</style>