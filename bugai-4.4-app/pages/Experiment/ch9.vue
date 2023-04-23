<template>
	<view class="content" :style="{height:screenHeight+'px'}">
		<view style="background-color: #609df8;"></view>
		<view class="mod1">
			<!-- 实验介绍 -->
			<view class="text">实验介绍：</view>
			<view>有一批糖果，从中随机取n=16袋，称得重量（单位为克）为:
				506,508,499,503,504,510,497,512,514,505,493,496,506,502,509,496.
				设袋装糖果的重量近似地服从正态分布，试求总体均值的置信水平为m=0.95的置信区间
			</view>
		</view>
		<view class="mod2">
			<!-- 实验部分 -->
			<button type="primary" plain="true" @click="exp()">开始实验</button>
			<view class="tu">
				<view class="a1">
					<image src="/static/qujian.png" v-show="showImg1"></image>
				</view>
			</view>
		</view>
		<view class="mod3">
			<!-- 实验小结 -->
			在实际应用中，我们往往无法观测整个总体，只能通过对一个样本进行观测来进行估计。
			由于样本是从总体中随机抽取的，因此不同样本可能会得到不同的估计结果。为了评估这种随机性对估计结果的影响，我们引入了置信区间的概念。
			置信区间是一个区间范围，它表示我们对总体参数的估计结果的不确定性。具体来说，我们可以说，在一定置信水平下，真实总体参数的值有95%的概率落在这个区间内。
		</view>

	</view>
</template>

<script>
	export default {
		data() {
			return {

				showImg1: false,
			}
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
		height: 320px;
		background-color: #ffffff;
		justify-content: center;
		border-radius: 5px;
	}

	.mod3 {
		margin: 3px;
		padding: 5px;
		width: 90%;
		/* height: 500px; */
		background-color: #ffffff;
		font-size: 16px;
		font-weight: 500;
		/* color: black; */
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