<template>
	<view class="container">
		<view class="section">
			<view class="title">什么是置信区间？</view>
			<view class="content">
				<p>在统计学中，我们常常需要对一个总体参数进行估计。例如，我们可能需要估计一个总体的平均值、方差、比例等。然而，在实际应用中，我们往往无法观测到整个总体，而只能通过对一个样本进行观测来进行估计。</p>
				<p>由于样本是从总体中随机抽取的，因此不同样本可能会得到不同的估计结果。为了评估这种随机性对估计结果的影响，我们引入了置信区间的概念。</p>
				<p>置信区间是一个区间范围，它表示我们对总体参数的估计结果的不确定性。具体来说，我们可以说，在一定置信水平下，真实总体参数的值有95%的概率落在这个区间内。</p>
				<p>除了判断总体参数的可能范围之外，置信区间还可以用于做出决策或进行推断。例如，在比较两个总体参数时，我们可以根据它们的置信区间来判断它们是否有显著差异。如果两个总体参数的置信区间不重叠，那么它们之间的差异可能是显著的。
				</p>
			</view>
		</view>
		<view class="section">
			<view class="title">如何计算置信区间？</view>
			<view class="content">
				<p>在实际应用中，我们通常会根据样本数据来计算置信区间。以样本均值的置信区间为例，我们可以使用下面的公式来计算置信区间的上下界：</p>
				<pre>
          x̄ ± zα/2 * σ/√n
        </pre>
				<p>其中，x̄是样本均值，σ是总体标准差，n是样本大小，zα/2是一个临界值，它可以根据置信水平和样本大小来查找标准正态分布表得到。</p>
				<p>对于其他类型的总体参数，我们也可以使用类似的公式来计算置信区间。例如，对于总体比例的置信区间，我们可以使用下面的公式来计算：</p>
				<pre>
          p̂ ± zα/2 * √(p̂(1-p̂)/n)
        </pre>
				<p>其中，p̂是样本比例，其余符号含义与样本均值的公式相同。</p>
				<p>需要注意的是，上面的公式都是基于一些假设条件得出的，例如总体是正态分布的。如果这些假设条件不满足，那么计算得到的置信区间可能不准确。</p>
			</view>
		</view>
		<view class="section">
			<view class="title">计算置信区间</view>
			<view class="content">
				<p>在下面的输入框中输入样本数据（以逗号分隔），然后点击“计算”按钮即可计算并展示置信区间的图形。</p>
				<input type="text" v-model="sampleData" placeholder="样本数据（以逗号分隔）" />
				<button @click="calculateConfidenceInterval">计算</button>
				<div v-if="confidenceInterval">
					<p>置信区间为：({{confidenceInterval.lower}}, {{confidenceInterval.upper}})</p>
					<div class="chart">
						<l-echart ref="chart" @finished="init"></l-echart>
					</div>
				</div>
			</view>
		</view>
	</view>

</template>

<script>
	// import echarts from '@/components/echarts'
	// import echarts from ‘@/components/echarts/echarts.min.js’
	import LEchart from '@/uni_modules/lime-echart/components/l-echart/l-echart.vue';
	import * as echarts from '@/uni_modules/lime-echart/static/echarts.min'
	import * as jStat from '@/utils/jstat.js'



	export default {
		name: "zhixingqujian",
		components: {
			LEchart
		},
		data() {
			return {
				sampleData: '', //样本数据
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









<style scoped>
	.content {
		margin-top: 2px;
	}

	.chart {
		margin-top: 20px;
		height: 300px;
	}

	.title {
		font-size: 24rpx;
		font-weight: bold;
		margin-bottom: 10rpx;
	}
</style>