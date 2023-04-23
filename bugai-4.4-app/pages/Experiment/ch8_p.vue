<template>
	<view class="content" :style="{height:screenHeight+'px'}">
		<view style="background-color: #609df8;"></view>
		<view class="mod1">
			<!-- 实验介绍 -->
<!-- 			假设我们有一组数据：1，3，5，7，9。我们想要估计这些数据的平均值。
			使用点估计方法，我们可以使用样本均值来估计总体均值。 -->
			 点估计是一种利用样本数据推断总体参数的方法。在点估计中，我们使用样本统计量（如样本均值、样本方差）来估计总体参数（如总体均值、总体方差）。点估计的目标是寻找一个点估计量，使其无偏或渐进无偏，并且具有最小的方差，从而提高估计的精度。
		</view>
		<view class="mod2">
			<dianguji></dianguji>
<!-- 			实验部分 -->
<!-- 			<view class="example">
				<view class="example-title">例子：</view>
				<view class="example-description">
					假设我们有一组数据：1，3，5，7，9。我们想要估计这些数据的平均值。使用点估计方法，我们可以使用样本均值来估计总体均值。
				</view>
				<view class="example-input">
					<view>输入数据:</view>
					<input v-model="data" type="text"></input>
				</view>
				<view class="example-output">
					<view>输出结果:</view>
					<text>{{result}}</text>
				</view>
				<button class="example-button" @click="calculate">计算</button>
			</view> -->
		</view>
		<view class="mod3">
			<!-- 实验小结 -->
			在统计学中，点估计是一种推断总体参数的方法，通过样本数据计算得到某个总体参数的估计值。
			点估计的目标是求出一个无偏估计量，即其期望值等于总体参数。常见的点估计方法包括最大似然估计和矩估计。
			点估计是利用样本数据来估计总体参数的方法，点估计的目的是通过一个点估计量来估计总体参数。
		</view>
	</view>
</template>

<script>
	import dianguji from '@/components/dianguji/dianguji.vue'
	export default {
		data() {
			return {
				screenHeight: uni.getSystemInfoSync().windowHeight,
				data: "1,3,5,7,9",
				result: ""
			};
		},
		components(){
			dianguji
		},
		methods: {
			calculate() {
				// 将输入数据转换为数组
				const arr = this.data.split(",").map(item => parseInt(item));
				// 计算样本均值
				const mean = arr.reduce((sum, current) => sum + current) / arr.length;
				this.result = `样本均值为${mean}`;
			}
		}
	};
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
		height: 380px;
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


	.title {
		font-size: 30px;
		font-weight: bold;
		margin-bottom: 10px;
	}

	.description {
		margin-bottom: 20px;
	}

	.example {
		border: 1px solid #ddd;
		padding: 10px;
	}

	.example-title {
		font-size: 20px;
		font-weight: bold;
		margin-bottom: 10px;
	}

	.example-description {
		margin-bottom: 20px;
	}

	.example-input {
		margin-bottom: 10px;
	}

	.example-output {
		margin-bottom: 10px;
	}

	input {
		border: 1px solid #ddd;
		padding: 5px;
		margin-left: 10px;
		width: 200px;
		height: 30px;
	}

	.example-button {
		background-color: #409eff;
		color: #fff;
		border: none;
		padding: 5px 10px;
		border-radius: 4px;
		cursor: pointer;
	}
</style>