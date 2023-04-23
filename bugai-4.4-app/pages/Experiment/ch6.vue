<template>
	<view class="content" :style="{height:screenHeight+'px'}">
		<view class="mod1">
			<!-- 实验介绍 -->
			<view>
				事件A在每次试验中发生的概率为p，记n次试验中事件A发生的次数为X，画出X的概率分布图。
			</view>

		</view>
		<view class="mod2">
			<!-- 实验部分 -->
			<erxiangfenbu></erxiangfenbu>
<!-- 			<div>
				<l-echart ref="chart" @finished="init"></l-echart>
			</div>
			
			<view style="display: inline-block;">请输入A发生的概率:</view>
			<input class="in1" v-model="pValue" @change="changeValue" type="number" placeholder="请输入p" />
			<view style="display: inline-block;">请输入事件总数:</view>
			<input class="in1" v-model="numberValue" @change="change" type="number" placeholder="请输入n" />

			<botton class="bt1" @click="changeOption">绘制分布律</botton>
			<table class="tb01" style="border: 2px #302cda solid">
				<tbody>
					<tr>
						<td style="border: 2px #302cda solid">X</td>
						<td style="border: 2px #302cda solid">Cell 2x1</td>
						<td style="border: 2px #302cda solid">Cell 3x1</td>
					</tr>
					<tr>
						<td style="border: 2px #302cda solid">Pk</td>
						<td style="border: 2px #302cda solid">Cell 2x2</td>
						<td style="border: 2px #302cda solid">Cell 3x2</td>
					</tr>
				</tbody>
			</table> -->
		</view>
		<view class="mod3">
			在概率论和统计学中，二项分布是n个独立的成功/失败试验中成功的次数的离散概率分布，其中每次试验的成功概率为p。这样的单次成功/失败试验又称为伯努利试验。
			实际上，当n=1时，二项分布就是伯努利分布。
			<br>
			一般地，如果随机变量服从参数为和的二项分布，我们记为X~B(n, p)或X~b(n, p)。
			n次试验中正好得到k次成功的概率由概率质量函数给出:P{X=k}=(n k)[P^k](1-p)^(n-k)。
		</view>
	</view>
</template>

<script>
	import erxiangfenbu from '@/components/erxiangfenbu/erxiangfenbu.vue'
	import LEchart from '@/uni_modules/lime-echart/components/l-echart/l-echart.vue';
	import * as echarts from '@/uni_modules/lime-echart/static/echarts.min'
	// import * as echarts from "@/static/js/echarts.js"
	export default {
		name: "yinbishiyan",
		data() {
			return {
				screenHeight: uni.getSystemInfoSync().windowHeight,
				numberValue: 0, //输入的次数
				pValue: 2, //改变的次数
				option: {
					title: {
						text: ' '
					},
					tooltip: {},
					legend: {
						data: ['二项分布']
					},
					xAxis: {
						data: ['0','1','2','3','4','5','6','7','8','9','10']
					},
					yAxis: {},
					series: [{
						name: 'p',
						type: 'bar',
						data: [0]
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
				this.pValue = value
				console.log('输入的次数：', this.pValue);
			},
			blur(e) {
				console.log('blur:', e);
			},
			focus(e) {
				console.log('focus:', e);
			},

			async changeOption() {
				var that = this
				this.zhengCount = 0
				this.fangCount = 0
				const data = this.option.series[0].data
				const option = this.option
				// 随机更新示例数据
				//根据输入n改变x轴，根据p改变y轴上的值
				//设置变量
				this.numberValue += this.pValue
				console.log("总次数："+this.numberValue)
				var that = this
				//向服务器发起请求
				this.request({
					url: "/experience/tossCoin",
					method: "POST",
					data: {
						"count": that.pValue
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
						that.zhengCount = Math.floor(Math.random() * that.pValue+1)
						that.fangCount = this.pValue-zhengCount
						
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
			LEchart,
			erxiangfenbu
		}
	}
		
	// export default {
	// 	//1.在data中定义数学公式，注意数学公式需要用**$$**签后包裹，中间才是公式内容
	// 	data() {
	// 		return {
	// 			question2: '$$i=A/(t+b)^n$$',
	// 			question3: '$$i(t_b)=A[(1-n)*t/r+b]/[(t_b/r)+b]^(n+1)$$',
	// 			question4: '$$i(t_a)=A[(1-n)*t_a/(1-r)+b]/[(t_a/(1-r))+b]^(n+1)$$',
	// 			question5: '$$A=[A_1(1+ClgP)]/167$$',
	// 			question6: '$$a^2+b^2=c^2$$',
	// 		}
	// 	},
	// 	//在页面创建的时候调用methods中的formatMath的方法
	// 	created() {
	// 		this.formatMath();
	// 	},
	// 	methods: {
	// 		formatMath() {
	// 			setTimeout(() => {
	// 				this.$nextTick(() => {
	// 					if (this.MathJax.isMathjaxConfig) {
	// 						this.MathJax.initMathjaxConfig();
	// 					}
	// 					//这个地方的hello是对应要渲染数学公式的dom的class
	// 					this.MathJax.MathQueue('hello');
	// 				})
	// 			}, 500)
	// 		},
	// 	}

	// }
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
		width: 90%;
		/* height: 320px; */
		background-color: #ffffff;
		justify-content: center;
		border-radius: 5px;
	}

	.mod2 {
		margin: 3px;
		width: 90%;
		/* height: 320px; */
		background-color: #ffffff;
		padding-top: 10px;
		/* justify-content: center; */
		border-radius: 5px;
	}

	.mod3 {
		margin: 3px;
		width: 90%;
		/* height: 200px; */
		background-color: #ffffff;
		justify-content: center;
		border-radius: 8px;
	}

	.in1 {
		display: inline-block;
		margin-top: 10px;
		margin-left: 8px;
		border: 1px solid;
	}

	.tb01 {
		text-align: center;
		margin: 0px auto;
	}

	.bt1 {
		margin: 5px auto;
		text-align: center;
		padding: 5px;
		display: flex;
		background-color: #2979ff;
		color: #ffffff;
		weight: 50%;
		width: 100px;
		font-size: 18px;
		font-weight: 600;
		border-radius: 5px;
	}
</style>
