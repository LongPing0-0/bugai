<template>
	<!-- 	这是硬币echarts实验 -->
	<view>
		<!-- 按钮n -->
		<view style="display: flex;">
			<view><button>n:{{n}}</button></view>
			<view style="width: 100%">
				<slider value="1" @change="sliderChangeN" activeColor="#FFCC33" backgroundColor="#000000"
					block-color="#8A6DE9" block-size="20" min="1" max="20"/>
			</view>
		</view>
		
		<!-- 按钮p -->
		<view style="display: flex;">
			<view><button>p:{{p}}</button></view>
			<view style="width: 100%">
				<slider value="1" @change="sliderChangeP" activeColor="#FFCC33" backgroundColor="#000000"
					block-color="#8A6DE9" block-size="20" min="0" max="100"/>
			</view>
		</view>

		<div>
			<l-echart ref="chart" @finished="init"></l-echart>
		</div>
		<view>
			<!-- 			<div class="numberInput">
				<uni-section title="自定义背景" type="line" subTitle="使用 background 属性设置自定义背景色" padding>
					
					<uni-number-box :min="2" :max="100000" v-model="vModelValue" @change="changeValue" :step="1"
						background="#2979FF" color="#fff" />
				</uni-section>
			</div> -->
			<!-- @input="numberFixedDigit" -->


			<!-- 			<button size='mini' class="bt1" @click="changeOption">抛硬币</button>
			<button size='mini' class="bt2" @click="reStart">重置</button>
			<button size='mini' class="bt1" @click="bar">柱状图</button>
			<button size='mini' class="bt2" @click="line">折线图</button> -->
		</view>

	</view>
</template>


<script>
	import LEchart from '@/uni_modules/lime-echart/components/l-echart/l-echart.vue';
	import * as echarts from '@/uni_modules/lime-echart/static/echarts.min'
	// import * as echarts from "@/static/js/echarts.js"
	export default {
		name: "erxiangfenbu",
		data() {
			return {
				n: 20, // 试验次数
				p: 0.6, // 事件发生概率
				x: 0, // 成功次数
				chartData: [], // 柱状图数据
			}
		},
		watch: {
			n() {
				this.chartData = [...Array(this.n + 1).keys()].map(x => this.binomialProbability(this.n, this.p, x))
				this.drawChart()
			},
			p() {
				this.chartData = [...Array(this.n + 1).keys()].map(x => this.binomialProbability(this.n, this.p, x))
				this.drawChart()
			},
			x() {
				this.drawChart()
			}
		},
		mounted() {
			this.chartData = [...Array(this.n + 1).keys()].map(x => this.binomialProbability(this.n, this.p, x))
			this.drawChart()
			// this.initMydata()
			// this.$refs.chart.init(echarts, chart => {
			// 	chart.setOption(this.option);
			// });
		},
		methods: {
			//展示滑块
			sliderChangeP(e) {
				console.log('value 发生变化：' + e.detail.value)
				this.p = e.detail.value * 0.01
			},
			sliderChangeN(e) {
				console.log('value 发生变化：' + e.detail.value)
				this.n = e.detail.value
			},
			startErxiang() {
				console.log(this.p)
			},
			drawChart() {
				this.$refs.chart.init(echarts, chart => {
					chart.setOption({
						title: {
							text: '二项分布概率分布'
						},
						xAxis: {
							name: 'x',
							type: 'category',
							data: [...Array(this.n + 1).keys()]
						},
						yAxis: {
							name: '概率',
							type: 'value',
							max: 0.3
						},
						series: [{
							name: '概率',
							type: 'bar',
							data: this.chartData
						}]
					})
				});
			},
			// // 计算二项分布概率
			binomialProbability(n, p, x) {
				const coefficient = this.binomialCoefficient(n, x)
				return coefficient * Math.pow(p, x) * Math.pow(1 - p, n - x)
			},
			// 计算组合数
			binomialCoefficient(n, k) {
				let result = 1
				for (let i = 1; i <= k; i++) {
					result *= (n - i + 1) / i
				}
				return result
			},
		},
		components: {
			LEchart
		}
	}
</script>

<style>
	.numberInput {
		weight: 100%;
		align-items: center;
		margin: 10px;
		margin-left: 35%;
	}

	.bt1 {
		background-color: #5470c6;
		color: #ffffff;
		weight: 50%;
		margin-top: 5px;
		margin-left: 8px;
		padding: 5px;
		width: 45%;
		height: 45px;
		font-size: 18px;
		font-weight: 600;
		border-radius: 5px;

	}

	.bt2 {
		background-color: #5470c6;
		color: #ffffff;
		weight: 50%;
		margin-left: 10px;
		margin-right: 5px;
		padding: 5px;
		width: 45%;
		height: 45px;
		font-size: 18px;
		font-weight: 600;
		border-radius: 5px;

	}
</style>