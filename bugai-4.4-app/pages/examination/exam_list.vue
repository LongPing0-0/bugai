<!-- 考试列表页 -->
<template>
	<view class="page_big" :style="{height:screenheight+'px'}">
		<view class="page_content">
			<view class="exam_detail" v-for="(item,i) in examList" :key="i">
				<view class="detail_left">
					<image :src="img" mode=""></image>
				</view>
				<view class="detail_right">
					<view class="exam_title">
						{{item.title}}
					</view>
					<view class="pattern">
						班级：{{item.className}}
					</view>
					<view class="pattern">
						题量：共<text>{{item.subjectList.length}}</text>道题
					</view>
					<view class="pattern">
						开始时间：{{item.starTime}}
					</view>
					<view class="pattern">
						截止时间：{{item.endTime}}
					</view>
					<view class="exam_btn">
						<view class="start_exam" v-if="item.endTime>=nowTime" @click="runExam(item.id)">
							开始做题
						</view>
						<view class="analysis" v-if="item.endTime<nowTime" @click="runExamReview(item)">
							已经截止
						</view>
					</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				//当前时间
				nowTime: null,
				//当前屏幕高度
				screenheight: '',
				//导航栏背景色
				top_bgCl: {
					background: "#F5F7F6"
				},
				img:"../../static/exam_bg.png",
				//题目列表数据
				examList:[{
					'testpaperName':"我是试卷一哦",
					'questionSum':10,
					'exam':1
				},{
					'testpaperName':"我是试卷二哦",
					'questionSum':15,
				}],
			}			
		},
		mounted() {
			this.screenheight = uni.getSystemInfoSync().windowHeight
			this.getExamList()
			this.getNowTime()
		},
		onLoad(option) {
			
			this.init();
		},
		methods: {
			//获取考试信息
			getExamList(){
				this.request({
					url: "/exam/my",
					method: "GET"
				}).then(resp=>{
					console.log(resp)
					if(resp.code == 200){
						this.examList = resp.data
					}
				})
			},
			getNowTime(){
				// 获取当前时间
				let now = new Date();
				// 获取年份
				let year = now.getFullYear();
				// 获取月份，注意月份从0开始，需要加1
				let month = now.getMonth() + 1;
				// 获取日期
				let day = now.getDate();
				// 如果月份或日期小于10，前面需要加上0
				if (month < 10) {
				  month = '0' + month;
				}
				if (day < 10) {
				  day = '0' + day;
				}
				// 拼接成字符串，例如：2021-05-01
				let dateStr = year + '-' + month + '-' + day;
				// 输出结果
				console.log(dateStr);
				this.nowTime = dateStr
			},
			//调转考试加载页
			runExam(item){
				uni.navigateTo({
					url:'/pages/examination/one/one?param='+item
				})
			},
			runExamReview(item){
				//跳转解析页面
				uni.showToast({
					title: '该题库已截止',
					icon: 'none',  // 不显示图标
					duration: 1500
				});
				// uni.navigateTo({
				// 	url:'/pages/examination/jiexi/jiexi'
				// })
			},
			init: function(questionbankId,userid){
				
			}
		}
	}
</script>

<style lang="scss" scoped>
	page {
		background: #F5F7F6;
	}

	.page_big {
		width: 100%;
		background: #F5F7F6;
		padding: 0 20rpx 20rpx 20rpx;
		.page_content{
			width: 100%;
			height: 100%;
			.exam_detail{
				width: 100%;
				background: white;
				border-radius: 20rpx;
				box-shadow: 0px 0px 20rpx 1rpx rgba(0, 0, 0, 0.1);
				padding: 20rpx 20rpx 20rpx 20rpx;
				margin-top: 20rpx;
				display: flex;
				.detail_left{
					image{
						width: 200rpx;
						height: 140rpx;
					}
				}
				.detail_right{
					padding-left: 20rpx;
					width: 100%;
					.exam_title{
						text-align: justify;
					}
					.pattern{
						font-size: 24rpx;
						color: #b0b1b0;
						margin-top: 15rpx;
					}
					.exam_btn{
						display: flex;
						font-size: 24rpx;
						justify-content: flex-end;
						.start_exam{
							border-radius: 10rpx;
							background: #1991F3;
							color: #fff;
							padding: 10rpx 15rpx 10rpx 15rpx;
						}
						.analysis{
							border-radius: 10rpx;
							background: white;
							border: 1px solid red;
							color: red;
							padding: 10rpx 20rpx 10rpx 20rpx;
							margin-right: 10rpx;
						}
						.retest{
							border-radius: 10rpx;
							background: white;
							border: 1px solid #1991F3;
							color: #1991F3;
							padding: 10rpx 20rpx 10rpx 20rpx;
						}
					}
				}
			}
		}
	}
</style>
