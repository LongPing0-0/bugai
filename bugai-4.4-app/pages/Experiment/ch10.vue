
<template>
	<view class="content" :style="{height:screenHeight+'px'}">
		<view style="background-color: #609df8;"></view>
		<view class="mod1">
			<!-- 实验介绍 -->
			在下面的输入框中输入样本数据（以逗号分隔），然后点击“计算”按钮即可计算并展示置信区间的图形。
		</view>
		<view class="mod2">


			<view style="margin-top: 10px;">

				<view>
					<label for="p1" style="color :black">请输入样本数据(以逗号分隔)：</label>
					<!-- <input type="text" v-model="sampleData" placeholder="" style="padding: 3px; border-radius: 7px; border: 1px solid gray; "/> -->
					<div style="display: flex; align-items: center; color :black">
					  <label for="sampleData" style="margin-right: 10px;">例如：</label>
					  <input id="sampleData" type="text" v-model="sampleData" placeholder="" style="padding: 3px; border-radius: 7px; border: 1px solid gray;">
					  <button @click="calculateConfidenceInterval">开始计算</button>
					</div>

					
					<div v-if="confidenceInterval" style="color :black">
						<p>置信区间为：</p>
						<p>({{confidenceInterval.lower}}, {{confidenceInterval.upper}})</p>
						<div class="chart">
							<l-echart ref="chart" @finished="init"></l-echart>
						</div>
					</div>
				</view>
			</view>


		</view>
		<view class="mod3">

			<!-- 实验小结 -->
			以样本均值的置信区间为例，使用下面的公式来计算置信区间的上下界：<br>
			x̄ ± zα/2 * σ/√n
			<br>其中，x̄是样本均值，σ是总体标准差，n是样本大小，zα/2是一个临界值，它可以根据置信水平和样本大小来查找标准正态分布表得到。
			对于总体比例的置信区间，我们可以使用下面的公式来计算：<br>
			p̂ ± zα/2 * √(p̂(1-p̂)/n)
			<br>其中，p̂是样本比例，其余符号含义与样本均值的公式相同。
			需要注意的是，上面的公式都是基于一些假设条件得出的，例如总体是正态分布的。如果这些假设条件不满足，那么计算得到的置信区间可能不准确。

		</view>
	</view>
</template>

<script>
	import LEchart from '@/uni_modules/lime-echart/components/l-echart/l-echart.vue';
	import * as echarts from '@/uni_modules/lime-echart/static/echarts.min'
	import * as jStat from '@/utils/jstat.js'

	export default {
		data() {
			return {

				showImg1: false,
			}
		},
		components() {

		},
		data() {
			return {
				sampleData: '3,4,5', //样本数据
				confidenceInterval: null, //置信区间



				chartOptions: {
					tooltip: {
						trigger: 'axis',
						axisPointer: {
							type: 'cross'
						}
					},
					grid: {
						top: '10%',
						left: '10%',
						right: '10%',
						bottom: '15%'
					},
					xAxis: {
						type: 'category',
						boundaryGap: false,
						data: []
					},
					yAxis: {
						type: 'value',
						axisLabel: {
							formatter: '{value}%'
						}
					},
					series: [{
						type: 'line',
						data: []
					}]
				}
			}
		},

		// mounted() {
		//         // init(echarts, theme?:string, opts?:{}, chart => {})
		//         // echarts 必填， 非nvue必填，nvue不用填
		//         // theme 可选，应用的主题，目前只支持名称，如：'dark'
		//         // opts = { // 可选
		//         //  locale?: string  // 从 `5.0.0` 开始支持
		//         // }
		//         // chart => {} ， callback 返回图表实例
		//         this.$refs.chart.init(echarts, chart => {
		//             chart.setOption(this.chartOptions);
		//         });
		// 		this.$refs.chart.resize({width: 375, height: 375})
		//     },

		mounted() {
			// this.initMydata()
			this.$refs.chart.init(echarts, chart => {
				chart.setOption(this.chartOptions);
			});
		},

		methods: {
			calculateConfidenceInterval() {
				// 将输入的样本数据转换为数组
				const data = this.sampleData.split(',').map(Number)
				// 计算样本均值和标准差
				const n = data.length
				const mean = data.reduce((acc, val) => acc + val, 0) / n
				const std = Math.sqrt(data.reduce((acc, val) => acc + (val - mean) ** 2, 0) / (n - 1))
				// 计算临界值
				const alpha = 0.05 // 置信水平为95%
				const z = jStat.normal.inv(1 - alpha / 2, 0, 1)

				// 计算置信区间
				const lower = mean - z * std / Math.sqrt(n)
				const upper = mean + z * std / Math.sqrt(n)
				this.confidenceInterval = {
					lower,
					upper
				}



				// 构造数据并更新图表
				const chartData = [] //局部变量，不是vue返回的数据
				for (let i = lower - 0.5; i <= upper + 0.5; i += 0.1) {
					chartData.push({
						name: i.toFixed(1),
						value: jStat.normal.pdf(i, mean, std) *
							100
					})
				}
				this.chartOptions.xAxis.data = chartData.map(item => item.name)
				console.log(this.chartOptions.xAxis.data)
				this.chartOptions.series[0].data = chartData.map(item => item.value * 100)
			}
		},
		async init() {
			// this.$refs.chart.resize({width: 375, height: 375})
			// chart 图表实例不能存在data里
			const chart = await this.$refs.chart.init(echarts);
			chart.setOption(this.chartOptions)

		}
	}
</script>



<style>
	.content {
		display: flex;
		flex-direction: column;
		height: 1000px;
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
		height: auto;
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
	button {
	  background-color: #55aaff; /* 绿色 */
	  border: none;
	  color: white;
	  padding: 1px; /* 调整内边距 */
	  text-align: center;
	  text-decoration: none;
	  display: inline-block;
	  font-size: 12px; /* 调整字体大小 */
	  margin: 4px;
	  cursor: pointer;
	  border-radius: 10px;
	  width: 60px;
	  height: 30px;
	}


</style>