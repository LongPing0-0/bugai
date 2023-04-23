<template>
	<!-- 	这是排列组合实验 -->
	<view>
		<div class="bd">
			<l-echart ref="chart" @finished="init"></l-echart>
		</div>
		<view>
			<div style="margin-left: 20px;margin-bottom: 20px;">
				<span style="display: inline-block;">将</span>
				<uni-section style="display: inline-block;">
					<!-- @input="numberFixedDigit" -->
					<uni-number-box :min="1" :max="4" v-model="vModelValue" @change="changeValue" :step="1"
						background="#2979FF" color="#fff"></uni-number-box>
				</uni-section>
				<span>个小球进行全排列</span>
				<button class="begin" @click="changeArr">开始</button>
			</div>
			<!-- <button @click="input">输出</button> -->
			<div class="bdd">
				<dl style="margin-left: 160px;margin-top: 30px;">
					<dt v-for="(item,index) in items">
						<span v-for="childitem in item">{{childitem}}</span>
					</dt>
				</dl>
			</div>
			<div style="margin-top: 20px;margin-left: 20px;">
				<span>从</span>
				<uni-section style="display: inline-block;">
					<!-- @input="numberFixedDigit" -->
					<uni-number-box :min="1" :max="8" v-model="m" @change="changeValue2" :step="1" background="#2979FF"
						color="#fff"></uni-number-box>
				</uni-section>
				<span>个小球中选</span>
				<uni-section style="display: inline-block;">
					<!-- @input="numberFixedDigit" -->
					<uni-number-box :min="1" :max="6" v-model="n" @change="changeValue3" :step="1" background="#2979FF"
						color="#fff"></uni-number-box>
				</uni-section>
				<span>个进行组合</span>
				<button class="begin1" @click="combination">开始</button>
			</div>
		</view>
	</view>
</template>


<script>
	//this.$refs.chart.setOption(this.option) 更新otion值
	import LEchart from '@/uni_modules/lime-echart/components/l-echart/l-echart.vue';
	import * as echarts from '@/uni_modules/lime-echart/static/echarts.min'
	// import * as echarts from "@/static/js/echarts.js"
	export default {
		name: "pailiezuhe",
		data() {
			return {
				option: null,
				vModelValue: 1,
				m: 0,
				n: 0,
				c: ['⚪', '🤍', '🖤', '⚫', '⬜', '⬛'],
				items: null,
				arr: {
					name: '⚪',

				},
			}
		},
		mounted() {
			this.initMydata()
			this.$refs.chart.init(echarts, chart => {
				chart.setOption(this.option);
			});
		},
		methods: {
			cmn(m, n, currentIndex = 0, choseArr = [], result = []) {
				let mLen = m.length
				// 可选数量小于项所需元素的个数，则递归终止
				if (currentIndex + n > mLen) {
					return
				}
				for (let i = currentIndex; i < mLen; i++) {
					// n === 1的时候，说明choseArr在添加一个元素，就能生成一个新的完整项了。
					// debugger
					if (n === 1) {
						// 再增加一个元素就能生成一个完整项，再加入到结果集合中
						result.push([...choseArr, m[i]])
						// 继续下一个元素生成一个新的完整项
						i + 1 < mLen && this.cmn(m, n, i + 1, choseArr, result)
						break
					}
					// 执行到这，说明n > 2，choseArr还需要两个以上的元素，才能生成一个新的完整项。则递归，往choseArr添加元素
					this.cmn(m, n - 1, i + 1, [...choseArr, m[i]], result)
				}
				return result
			},
			combination() {
				var cb = this.c.slice(0, this.m);
				this.items = this.cmn(cb, this.n);
			},
			input() {
				// console.log('arr1111', this.cmn(this.c, 2))
				// var s=this.cmn(this.c, 2)
				console.log(this.items)
			},
			changeValue(value) {
				this.vModelValue = value
				console.log('输入的次数：', this.vModelValue);
			},
			changeValue2(value) {
				this.m = value
				console.log('输入的次数：', this.m);
			},
			changeValue3(value) {
				this.n = value
				console.log('输入的次数：', this.n);
			},
			changeArr() {
				var _this = this;
				if (this.vModelValue == 1) {

					var s1 = this.arr1()
					this.option.series = s1;
					this.$refs.chart.init(echarts, chart => {
						chart.setOption(this.option);
					});
				}
				if (this.vModelValue == 2) {
					var s2 = this.arr2()
					this.option.series = s2;
					this.$refs.chart.init(echarts, chart => {
						chart.setOption(this.option);
					});
				}
				if (this.vModelValue == 3) {
					var that = this
					var s3 = this.arr3()
					this.option.series = s3;
					// this.$refs.chart.setOption(this.option);
					this.$refs.chart.init(echarts, chart => {
						chart.setOption(that.option);
					});
				}
				if (this.vModelValue == 4) {
					var s4 = this.arr4()
					this.option.series = s4;
					this.$refs.chart.init(echarts, chart => {
						chart.setOption(this.option);
					});
				}
			},
			init() {
				this.$refs.chart.init(echarts, chart => {
					chart.setOption(this.option);
				});
			},
			initMydata() {
				var option
				// *****************写入echarts-----option**************************
				option = {
					title: {
						top: '0%',
						text: '补概-实验五'
					},
					series: [{
						data: [this.arr],
						type: 'tree',
						top: '5%',
						symbol: 'emptyCircle',
						expandAndCollapse: true,
						orient: 'vertical',
						label: {
							position: 'left',
							rotate: 0,
							verticalAlign: 'middle',
							align: 'right',
							fontSize: 10
						},
						leaves: {
							label: {
								position: 'right',
								rotate: 0,
								verticalAlign: 'middle',
								align: 'left'
							}
						},
						animationDurationUpdate: 750
					}]
				}
				// *****************写入echarts-----option**************************
				this.option = option
			},
			//*******************************************************
			//当一个球时排列
			arr1() {
				var series = [{
					data: [{
						name: '⚪',
					}],
					height: '30%',
					type: 'tree',
					top: '40%',
					symbol: 'emptyCircle',
					expandAndCollapse: true,
					orient: 'vertical',
					label: {
						position: 'left',
						rotate: 0,
						verticalAlign: 'middle',
						align: 'middle',
						padding: [0, 0, 0, 20]
					},
					leaves: {
						label: {
							position: 'left',
							rotate: 0,
							verticalAlign: 'middle',
							align: 'middle',
							padding: [0, 0, 0, 20]
						}
					},
					animationDurationUpdate: 750
				}];
				return series;
			},
			//*******************************************************
			//当两个球时排列
			arr2() {
				var series = [{
						data: [{
							name: '⚪',
							children: [{
								name: '🤍'
							}]
						}],
						height: '50%',
						type: 'tree',
						top: '20%',
						right: '40%',
						symbol: 'emptyCircle',
						expandAndCollapse: true,
						orient: 'vertical',
						label: {
							position: 'left',
							rotate: 0,
							verticalAlign: 'middle',
							align: 'middle',
							padding: [0, 0, 0, 20]
						},
						leaves: {
							label: {
								position: 'left',
								rotate: 0,
								verticalAlign: 'middle',
								align: 'middle',
								padding: [0, 0, 0, 20]
							}
						},
						animationDurationUpdate: 750
					},
					{
						data: [{
							name: '🤍',
							children: [{
								name: '⚪'
							}]
						}],
						height: '50%',
						type: 'tree',
						top: '20%',
						left: '30%',
						symbol: 'emptyCircle',
						expandAndCollapse: true,
						orient: 'vertical',
						label: {
							position: 'left',
							rotate: 0,
							verticalAlign: 'middle',
							align: 'middle',
							padding: [0, 0, 0, 20]
						},
						leaves: {
							label: {
								position: 'left',
								rotate: 0,
								verticalAlign: 'middle',
								align: 'middle',
								padding: [0, 0, 0, 20]
							}
						},
						animationDurationUpdate: 750
					}
				];
				return series;
				// _this.option.series=series;
				// _this.$refs.chart.setOption(_this.option);
				},
			//*******************************************************
				//当三个球时排列				arr3() {
				var series = [{
						data: [{
							name: '⚪',
							children: [{
									name: '🤍',
									children: [{
										name: '⚫'
									}]
								},
								{
									name: '⚫',
									children: [{
										name: '🤍'
									}]
								},
							]
						}],
						height: '40%',
						width: '30%',
						type: 'tree',
						top: '3%',
						right: '5%',
						left: '35%',
						symbol: 'emptyCircle',
						expandAndCollapse: true,
						orient: 'vertical',
						label: {
							position: 'left',
							rotate: 0,
							verticalAlign: 'middle',
							align: 'middle',
							padding: [0, 0, 0, 20]
						},
						leaves: {
							label: {
								position: 'left',
								rotate: 0,
								verticalAlign: 'middle',
								align: 'middle',
								padding: [0, 0, 0, 20]
							}
						},
						animationDurationUpdate: 750
					},
					{
						data: [{
							name: '🤍',
							children: [{
									name: '⚪',
									children: [{
										name: '⚫'
									}]
								},
								{
									name: '⚫',
									children: [{
										name: '⚪'
									}]
								}
							]
						}],
						height: '40%',
						width: '30%',
						type: 'tree',
						top: '40%',
						left: '15%',
						symbol: 'emptyCircle',
						expandAndCollapse: true,
						orient: 'vertical',
						label: {
							position: 'left',
							rotate: 0,
							verticalAlign: 'middle',
							align: 'middle',
							padding: [0, 0, 0, 20]
						},
						leaves: {
							label: {
								position: 'left',
								rotate: 0,
								verticalAlign: 'middle',
								align: 'middle',
								padding: [0, 0, 0, 20]
							}
						},
						animationDurationUpdate: 750
					},
					{
						data: [{
							name: '⚫',
							children: [{
									name: '⚪',
									children: [{
										name: '🤍'
									}]
								},
								{
									name: '🤍',
									children: [{
										name: '⚪'
									}]
								}
							]
						}],
						height: '40%',
						width: '30%',
						type: 'tree',
						top: '40%',
						right: '15%',
						symbol: 'emptyCircle',
						expandAndCollapse: true,
						orient: 'vertical',
						label: {
								position: 'left',								rotate: 0,
							verticalAlign: 'middle',
								align: 'middle',								padding: [0, 0, 0, 20]
						},
						leaves: {
							label: {
								position: 'left',
								rotate: 0,
								verticalAlign: 'middle',
								align: 'middle',
								padding: [0, 0, 0, 20]
							}
						},
						animationDurationUpdate: 750
					}
				];
				return series;				},
				//*******************************************************				//当三个球时排列
			arr4() {
				var series = [{
						data: [{
							name: '⚪',
							children: [{
									name: '⚫',
									children: [{
											name: '🤍',
											children: [{
												name: '🖤'
											}]
										},
										{
											name: '🖤',
											children: [{
												name: '🤍'
											}]
										}
									]
								},
								{
									name: '🤍',
									children: [{
											name: '🖤',
											children: [{
												name: '⚫'
											}]
										},
										{
											name: '⚫',
											children: [{
												name: '🖤'
											}]
										}
									]
								},
								{
									name: '🖤',
									children: [{
											name: '⚫',
											children: [{
												name: '🤍'
											}]
										},
										{
											name: '🤍',
											children: [{
												name: '⚫'
											}]
										}
									]
								}
							]
						}],
						initialTreeDepth: -1,
						height: '30%',
						width: '30%',
						type: 'tree',
						top: '15%',
						left: '10%',
						symbol: 'emptyCircle',
						expandAndCollapse: true,
						orient: 'vertical',
						label: {								position: 'left',
								rotate: 0,
								verticalAlign: 'middle',
							align: 'middle',
								padding: [0, 0, 0, 20]
						},
						leaves: {
							label: {
								position: 'left',
								rotate: 0,
								verticalAlign: 'middle',
								align: 'middle',
								padding: [0, 0, 0, 20]
							}
						},
						animationDurationUpdate: 750
					},
					{
						data: [{
							name: '⚫',
							children: [{
									name: '⚪',
									children: [{
											name: '🤍',
											children: [{
												name: '🖤'
											}]
										},
										{
											name: '🖤',
											children: [{
												name: '🤍'
											}]
										}
									]
								},
								{
									name: '🤍',
									children: [{
											name: '🖤',
											children: [{
												name: '⚪'
											}]
										},
										{
											name: '⚪',
											children: [{
												name: '🖤'
											}]
										}
									]
								},
								{
									name: '🖤',
									children: [{
											name: '⚪',
											children: [{
												name: '🤍'
											}]
										},
										{
											name: '🤍',
											children: [{
												name: '⚪'
											}]
										}
									]
								}
							]
						}],
						initialTreeDepth: -1,
						height: '30%',
						width: '30%',
						type: 'tree',
						top: '15%',
						right: '10%',
						symbol: 'emptyCircle',
						expandAndCollapse: true,
						orient: 'vertical',
						label: {
								position: 'left',								rotate: 0,								verticalAlign: 'middle',
							align: 'middle',
								padding: [0, 0, 0, 20]
						},
						leaves: {
							label: {
								position: 'left',
								rotate: 0,
								verticalAlign: 'middle',
								align: 'middle',
								padding: [0, 0, 0, 20]
							}
						},
						animationDurationUpdate: 750
					},
					{
						data: [{
							name: '🤍',
							children: [{
									name: '⚫',
									children: [{
											name: '⚪',
											children: [{
												name: '🖤'
											}]
										},
										{
											name: '🖤',
											children: [{
												name: '⚪'
											}]
										}
									]
								},
								{
									name: '⚪',
									children: [{
											name: '🖤',
											children: [{
												name: '⚫'
											}]
										},
										{
											name: '⚫',
											children: [{
												name: '🖤'
											}]
										}
									]
								},
								{
									name: '🖤',
									children: [{
											name: '⚫',
											children: [{
												name: '⚪'
											}]
										},
										{
											name: '⚪',
											children: [{
												name: '⚫'
											}]
										}
									]
								}
							]
						}],
						initialTreeDepth: -1,
						height: '30%',
						width: '30%',
						type: 'tree',
						bottom: '10%',
						left: '10%',
						symbol: 'emptyCircle',
						expandAndCollapse: true,
						orient: 'vertical',
						label: {
								position: 'left',								rotate: 0,								verticalAlign: 'middle',
							align: 'middle',
								padding: [0, 0, 0, 20]
						},
						leaves: {
							label: {
								position: 'left',
								rotate: 0,
								verticalAlign: 'middle',
								align: 'middle',
								padding: [0, 0, 0, 20]
							}
						},
						animationDurationUpdate: 750
					},
					{
						data: [{
							name: '🖤',
							children: [{
									name: '⚫',
									children: [{
											name: '🤍',
											children: [{
												name: '⚪'
											}]
										},
										{
											name: '⚪',
											children: [{
												name: '🤍'
											}]
										}
									]
								},
								{
									name: '🤍',
									children: [{
											name: '⚪',
											children: [{
												name: '⚫'
											}]
										},
										{
											name: '⚫',
											children: [{
												name: '⚪'
											}]
										},
									]
								},
								{
									name: '⚪',
									children: [{
											name: '⚫',
											children: [{
												name: '🤍'
											}]
										},
										{
											name: '🤍',
											children: [{
												name: '⚫'
											}]
										}
									]
								}
							]
						}],
						initialTreeDepth: -1,
						height: '30%',
						width: '30%',
						type: 'tree',
						bottom: '10%',
						right: '10%',
						symbol: 'emptyCircle',
						expandAndCollapse: true,
						orient: 'vertical',
						label: {
								position: 'left',
								rotate: 0,								verticalAlign: 'middle',								align: 'middle',
								padding: [0, 0, 0, 20]
						},
						leaves: {
							label: {
								position: 'left',
								rotate: 0,
								verticalAlign: 'middle',
								align: 'middle',
								padding: [0, 0, 0, 20]
							}
						},
						animationDurationUpdate: 750
					}
				];
				return series;
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
</style>
<style>
	.begin {
		/* display: inline-block; */
		background-color: #2979ff;
		color: #ffffff;
		weight:50%;
		margin-top: 8px;
		margin-left: 8px;
		align-items: center;
		width: 80px;
		height: 35px;
		font-size: 18px;
		font-weight: 600;
		border-radius: 5px;
	}

	,
	.begin1 {
		align-items: center;
		background-color: #2979ff;
		color: #ffffff;
		weight:50%;
		width: 80px;
		height: 35px;
		font-size: 18px;
		font-weight: 600;
		border-radius: 5px;
	}

	.numberInput {
		/* align-items: center; */
		/* margin: 20px; */

	}

	.bd {
		font-family: Arial;
		font-size: 18px;
		line-height: 30px;
		font-weight: bold;
		color: white;
		padding-right: 10px;
		/* box-shadow: 0 0 0 10px #296796; */
		border: 2px solid #2a5dbc;
		/* outline: dashed 10px white; */
	}

	.bdd {
		font-family: Arial;
		font-size: 18px;
		line-height: 30px;
		font-weight: bold;
		color: white;
		height: 300px;
		margin-top: 10px;
		padding-top: 5px;
		padding-bottom: 15px;
		border: 2px solid #2a5dbc;
/* 		background:
			linear-gradient(to top, #4caf50, #4caf50 10px, transparent 10px),
			linear-gradient(to right, #c1ef8c, #c1ef8c 10px, transparent 10px),
			linear-gradient(to bottom, #8bc34a, #8bc34a 10px, transparent 10px),
			linear-gradient(to left, #009688, #009688 10px, transparent 10px);
		background-origin: border-box; */
	}
</style>
