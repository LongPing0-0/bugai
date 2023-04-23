<template>
	<!-- 这是打靶实验 -->
	<view class="content2">
		<div>
			<l-echart ref="chart" @finished="init"></l-echart>
		</div>
		<table class="tb" border='1'>
			<tr>
				<th>射击</th>
				<th v-for="n in 10">{{n}}</th>
				<th>期望</th>
				<th>方差</th>
			</tr>
			<tr>
				<td>成绩</td>
				<td v-for="x in num">{{x}}</td>
				<td>{{expectations(num)}}</td>
				<td>{{variance(num)}}</td>
			</tr>
		</table>
		<button class="bt1" @click="addPoint()">开始打靶</button>
	</view>
</template>


<script>
	
	//this.$refs.chart.setOption(this.option) 更新otion值
	import LEchart from '@/uni_modules/lime-echart/components/l-echart/l-echart.vue';
	import * as echarts from '@/uni_modules/lime-echart/static/echarts.min'
	// import * as echarts from "@/static/js/echarts.js"
	export default {
		name: "targetPractice",
		data() {
			return {
				n:0,
				option: null,
				num:[1,2,3,4,5,6,7,8,9,0]
			}
		},
		mounted() {
			this.initMydata()
			this.$refs.chart.init(echarts, chart => {
				chart.setOption(this.option);
			});
		},
		methods: {

			init() {
				this.$refs.chart.init(echarts, chart => {
					chart.setOption(this.option);
				});
			},
			initMydata(data) {
				var option = data
				// *****************写入echarts-----option**************************
				option = {
					title:{
						bottom:'0%',
						text:''
					},
					legend:{
						type:'scroll',
						icon:'circle',
						itemWidth:10,
						itemHeight:10,
						// right:'5%'
					},
					radar:{
						indicator:[
							{ name: '       ', max: 10 },
							{ name: '', max: 10 },
							{ name: '', max: 10 },
							{ name: '', max: 10 },
							{ name: '', max: 10 },
							{ name: '', max: 10 },
							{ name: '', max: 10 },
							{ name: '', max: 10 },
							{ name: '', max: 10 },
							{ name: '', max: 10 },
							{ name: '', max: 10 },
							{ name: '', max: 10 }
						],
						center:['50%','50%'],
						radius:130,
						splitNumber:10,
						shape: 'circle',
						axisLine: {
						    show:false
						},
					},
					series: [{
						type:'radar',
						data:[
							{
								value:[0,0,0,0,0,0,0,0,0,0,0,0],
								name:'point1',
								lineStyle:{
								  opacity:0
								}
							}
						]
					},{
						type:'radar',
						data:[
							{
								value:[0,0,0,0,0,0,0,0,0,0,0,0],
								name:'point2',
								lineStyle:{
								  opacity:0
								}
							}
						]
					},{
						type:'radar',
						data:[
							{
								value:[0,0,0,0,0,0,0,0,0,0,0,0],
								name:'point3',
								lineStyle:{
								  opacity:0
								}
							}
						]
					},{
						type:'radar',
						data:[
							{
								value:[0,0,0,0,0,0,0,0,0,0,0,0],
								name:'point4',
								lineStyle:{
								  opacity:0
								}
							}
						]
					},{
						type:'radar',
						data:[
							{
								value:[0,0,0,0,0,0,0,0,0,0,0,0],
								name:'point5',
								lineStyle:{
								  opacity:0
								}
							}
						]
					},{
						type:'radar',
						data:[
							{
								value:[0,0,0,0,0,0,0,0,0,0,0,0],
								name:'point6',
								lineStyle:{
								  opacity:0
								}
							}
						]
					},{
						type:'radar',
						data:[
							{
								value:[0,0,0,0,0,0,0,0,0,0,0,0],
								name:'point7',
								lineStyle:{
								  opacity:0
								}
							}
						]
					},{
						type:'radar',
						data:[
							{
								value:[0,0,0,0,0,0,0,0,0,0,0,0],
								name:'point8',
								lineStyle:{
								  opacity:0
								}
							}
						]
					},{
						type:'radar',
						data:[
							{
								value:[0,0,0,0,0,0,0,0,0,0,0,0],
								name:'point9',
								lineStyle:{
								  opacity:0
								}
							}
						]
					},{
						type:'radar',
						data:[
							{
								value:[0,0,0,0,0,0,0,0,0,0,0,0],
								name:'point10',
								lineStyle:{
								  opacity:0
								}
							}
						]
					}]
				}
				// *****************写入echarts-----option**************************
				this.option = option
			},
			//1、随机得到靶点数据,返回一个数组
			adrPoint(){
				var data,x,y;
				x=0;
				do{
					x=Math.ceil(Math.random()*12)-1
				}while(x<0);
				// console.log(x);//随机生成所在主轴x位置，并避免为负数（数组报错）
				y=Math.ceil(Math.random()*10);
				console.log(y); //随机生成打靶环数y的值
				// num[n]=y;
				data=[0,0,0,0,0,0,0,0,0,0,0,0];
				data[x]=y;
				return [data,y];
			},
			//2、添加靶点到图上，调用adrPoint
			addPoint(){
				if(this.n==10){
					this.n=0;
				}
				while(this.n<10){
					var obj=this.$options.methods.adrPoint();
					// console.log(obj);
					this.num[this.n]=obj[1];
					this.option.series[this.n].data[0].value=obj[0];
					this.$refs.chart.setOption(this.option);
					this.n++;
				}
				console.log(this.num);
				for(var i=0;i<this.num.length;i++){
					this.num[i]=11-this.num[i];
				}
				this.$forceUpdate();
				// console.log(this.option.series)
			},
			variance(numbers){
				var mean = 0;  
				    var sum = 0;  
				    for(var i=0;i<numbers.length;i++){  
				        sum += numbers[i];  
				    }  
				    mean = sum / numbers.length;  
				    sum = 0;  
				    for(var i=0;i<numbers.length;i++){  
				        sum += Math.pow(numbers[i] - mean , 2);  
				    }  
				    return (sum / numbers.length).toFixed(2);
			},
			expectations(numbers){
				var sum = 0;
				for(var i=0;i<numbers.length;i++){
					sum += numbers[i];
				}
				return (sum/numbers.length).toFixed(2);
			}
		},
		components: {
			LEchart
		}
	}
</script>

<style>
	.numberInput {
		align-items: center;
		margin: 20px;
	}
	.tb{
		height:10px;
		background-color: #5470c6;
		color: #ffffff;
		width:100%;overflow:hidden;
	}
	.bt1{
		margin: 3%;
		height: 45px;
		width: 150px;
		margin-left: 30%;
		font-weight: 600;
	}
</style>
