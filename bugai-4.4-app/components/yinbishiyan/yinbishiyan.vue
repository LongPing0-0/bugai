<template>
<!-- 	这是硬币echarts实验 -->
	<view>
		<div>
			<l-echart ref="chart" @finished="init"></l-echart>
		</div>
		<view>
			<div class="numberInput">
				<uni-section title="自定义背景" type="line" subTitle="使用 background 属性设置自定义背景色" padding>
					<!-- @input="numberFixedDigit" -->
					<uni-number-box :min="2" :max="100000" v-model="vModelValue" @change="changeValue" :step="1"
						background="#2979FF" color="#fff" />
				</uni-section>
			</div>
			<button size='mini' class="bt1" @click="changeOption">抛硬币</button>
			<button size='mini' class="bt2" @click="reStart">重置</button>
			<button size='mini' class="bt1" @click="bar">柱状图</button>
			<button size='mini' class="bt2" @click="line">折线图</button>
		</view>

	</view>
</template>


<script>
	import LEchart from '@/uni_modules/lime-echart/components/l-echart/l-echart.vue';
	import * as echarts from '@/uni_modules/lime-echart/static/echarts.min'
	// import * as echarts from "@/static/js/echarts.js"
	export default {
		name: "yinbishiyan",
		data() {
			return {
				zhengCount: 0,
				fangCount: 0,
				zheng: 0,
				fang: 0,
				numberValue: 0, //输入的次数
				vModelValue: 2, //改变的次数
				option: {
					title: {
						text: ' '
					},
					tooltip: {},
					legend: {
						data: ['抛硬币']
					},
					xAxis: {
						data: ["正", "反"]
					},
					yAxis: {},
					series: [{
						name: '抛硬币',
						type: 'bar',
						data: [0, 0]
					}]
				}
			}
		},
		mounted() {
			// this.initMydata()
			this.$refs.chart.init(echarts, chart => {
				chart.setOption(this.option);
			});
		},
		methods: {
			// 输入次数 --- begin
			change(value) {
				this.numberValue = value
			},
			changeValue(value) {
				this.vModelValue = value
				console.log('输入的次数：', this.vModelValue);
			},
			blur(e) {
				console.log('blur:', e);
			},
			focus(e) {
				console.log('focus:', e);
			},
			// numberFixedDigit (e) { // 只能输入整数
			//   e.target.value = e.target.value.replace(/^0|[^\d]|[.]/g, '')
			//   var that = this
			//   this.$nextTick(() => {
			//     that.vModelValue= e.target.value
			//   })
			// },
			// 输入次数 --- end
			
			async changeOption() {
				var that = this
				this.zhengCount = 0
				this.fangCount = 0
				const data = this.option.series[0].data
				const option = this.option
				// 随机更新示例数据
				//设置变量
				this.numberValue += this.vModelValue
				console.log("总次数："+this.numberValue)
				var that = this
				//向服务器发起请求
				this.request({
					url: "/experience/tossCoin",
					method: "POST",
					data: {
						"count": that.vModelValue
					}
				}).then(resp=>{
					console.log(resp)
					if(resp.code == 200){
						that.zhengCount = resp.data.zheng
						that.fangCount = resp.data.fang
						
						//插入
						console.log("zheng-count:"+that.zhengCount)
						console.log("fang-count:"+that.fangCount)
						
						this.zheng += that.zhengCount
						console.log("zheng:"+this.zheng)
						this.fang += that.fangCount
						console.log("fang:"+this.fang)
						console.log(this.zheng)
						console.log(this.fang)
						data[0] = this.zheng
						data[1] = this.fang
						//更新图表
						console.log(data)
						this.option.series[0].data = data
						this.$refs.chart.setOption(this.option)
					}else{
						that.zhengCount = Math.floor(Math.random() * that.vModelValue+1)
						that.fangCount = this.vModelValue-zhengCount
						
						//插入
						console.log("zheng-count:"+that.zhengCount)
						console.log("fang-count:"+that.fangCount)
						
						this.zheng += that.zhengCount
						console.log("zheng:"+this.zheng)
						this.fang += that.fangCount
						console.log("fang:"+this.fang)
						console.log(this.zheng)
						console.log(this.fang)
						data[0] = this.zheng
						data[1] = this.fang
						//更新图表
						console.log(data)
						this.option.series[0].data = data
						this.$refs.chart.setOption(this.option)
					}
				})


			},
			onViewClick(options) {
				console.log(options)
			},
			init() {
				this.$refs.chart.init(echarts, chart => {
					chart.setOption(this.option);
				});
			},
			async initMydata(data) {
				var option = data
				// *****************写入echarts-----option**************************

				// *****************写入echarts-----option**************************
				console.log(data)
			},
			async reStart(){
				
				

				//重置次数
				this.zheng = 0
				this.fang = 0
				this.option.series[0].data = [0,0]
				this.$refs.chart.setOption(this.option)
			},
			async line(){
				this.option.series[0].type = 'line'
				this.$refs.chart.setOption(this.option)
			},
			async bar(){
				this.option.series[0].type = 'bar'
				this.$refs.chart.setOption(this.option)
			}

		},
		components: {
			LEchart
		}
	}
</script>

<style>
	.numberInput{
		weight:100%;
		align-items: center;
		margin: 10px;
		margin-left: 35%;
	}
	.bt1{
		background-color: #5470c6;
		color: #ffffff;
		weight:50%;
		margin-top: 5px;
		margin-left: 8px;
		padding: 5px;
		width: 45%;
		height: 45px;
		font-size: 18px;
		font-weight: 600;
		border-radius: 5px;
		
	}
	.bt2{
		background-color: #5470c6;
		color: #ffffff;
		weight:50%;
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
