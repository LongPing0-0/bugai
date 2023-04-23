<template>
	<!-- 	这是硬币echarts实验 -->
	<view>
		<!-- 按钮u -->
		<view style="display: flex;">
			<view><button>u:{{u}}</button></view>
			<view style="width: 100%">
				<slider value="0" @change="sliderChangeU" activeColor="#FFCC33" backgroundColor="#000000"
					block-color="#8A6DE9" block-size="20" min="-1000" max="1000"/>
			</view>
		</view>
		<!-- 按钮sigma -->
		<view style="display: flex;">
			<view><button>sigma:{{sigma}}</button></view>
			<view style="width: 100%">
				<slider value="1" @change="sliderChangeSigma" activeColor="#FFCC33" backgroundColor="#000000"
					block-color="#8A6DE9" block-size="20" min="1" max="500"/>
			</view>
		</view>
		<view>
<!-- 			<button @click="resetMy()">重置</button> -->
			<button @click="huitu()">
				开始绘图
			</button>
			<button @click="biaozhun()">标准正态分布</button>
		</view>
		
		
		<div>
			<l-echart ref="chart" @finished="init"></l-echart>
		</div>
		<view>
			
		</view>

	</view>
</template>


<script>
	import LEchart from '@/uni_modules/lime-echart/components/l-echart/l-echart.vue';
	import * as echarts from '@/uni_modules/lime-echart/static/echarts.min'
	// import * as echarts from "@/static/js/echarts.js"
	export default {
		name: "zhengtaifenbu",
		data() {
			return {
				u: 0,
				sigma: 1,
				chartData: [], // 柱状图数据
			}
		},
		mounted() {
			this.drawChart()
		},
		methods: {
			biaozhun(){
				this.u = 0
				this.sigma = 1
				this.huitu()
			},
			resetMy(){
				this.u = 0
				this.sigma = 1
			},
			huitu(){
				console.log("绘图")
				this.request({
					url: "/math/zt",
					method: "POST",
					data: {
						u: this.u,
						sigma: this.sigma
					}
				}).then(resp=>{
					console.log(resp)
					if(resp.code == 200){
						this.$refs.chart.init(echarts, chart => {
							chart.setOption({
								title: {
									text: '正态分布分布'
								},
								xAxis: {
									name: 'x',
									type: 'category',
									data: [-4.0, -3.9, -3.8, -3.7, -3.6, -3.5, -3.4, -3.3, -3.2, 
									-3.1, -3.0, -2.9, -2.8, -2.7, -2.6 -2.5, -2.4, -2.3, 
									-2.2, -2.1, -2.0, -1.9, -1.8, -1.7, -1.6, -1.5, -1.4,
									 -1.3, -1.2, -1.1, -1.0, -0.9, -0.8, -0.7, -0.6, -0.5, 
									 -0.4, -0.3, -0.2, -0.1, 0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6,
									  0.7, 0.8, 0.9, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7, 1.8, 
									  1.9, 2.0, 2.1, 2.2, 2.3, 2.4, 2.5, 2.6, 2.7, 2.8, 2.9, 3.0,
									   3.1, 3.2, 3.3, 3.4, 3.5, 3.6, 3.7, 3.8, 3.9,4.0]
									// data: [0,1,2,3,4]
						
								},
								yAxis: {
									name: '概率',
									type: 'value',
									max: 1.0
						
								},
								series: [{
									name: '概率',     //y轴0——1 x轴-5到5  一位  u-10.00到+10.00，siguama0.01到5.00
									type: 'line',
									data: resp.data
								}]
							})
						});
					}
				})
			},
			//展示滑块
			        sliderChangeU(e) {
			            console.log('value 发生变化：' + e.detail.value)
						this.u = e.detail.value * 0.01
			        },
					//展示滑块
					        sliderChangeSigma(e) {
					            console.log('value 发生变化：' + e.detail.value)
								this.sigma = e.detail.value*0.01
					        },
					
			startErxiang(){
				console.log(this.p)
			},
			drawChart() {
				this.$refs.chart.init(echarts, chart => {
					chart.setOption({
						title: {
							text: '正态分布分布'
						},
						xAxis: {
							name: 'x',
							type: 'category',
							data: [-4.0, -3.9, -3.8, -3.7, -3.6, -3.5, -3.4, -3.3, -3.2, -3.1, -3.0, -2.9, -2.8, -2.7, -2.6 -2.5, -2.4, -2.3, -2.2, -2.1, -2.0, -1.9, -1.8, -1.7, -1.6, -1.5, -1.4, -1.3, -1.2, -1.1, -1.0, -0.9, -0.8, -0.7, -0.6, -0.5, -0.4, -0.3, -0.2, -0.1, 0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7, 1.8, 1.9, 2.0, 2.1, 2.2, 2.3, 2.4, 2.5, 2.6, 2.7, 2.8, 2.9, 3.0, 3.1, 3.2, 3.3, 3.4, 3.5, 3.6, 3.7, 3.8, 3.9,4.0]
							// data: [0,1,2,3,4]

						},
						yAxis: {
							name: '概率',
							type: 'value',

						},
						series: [{
							name: '概率',     //y轴0——1 x轴-5到5  一位  u-10.00到+10.00，siguama0.01到5.00
							type: 'line',
							data: this.chartData
						}]
					})
				});
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