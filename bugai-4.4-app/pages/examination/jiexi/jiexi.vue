<template>
	<view>
		<view id="top-box" class="cu-bar bg-white solid-bottom">
			<view class="action text-black">
				<text v-if="currentType===1">判断题</text>
				<text v-else-if="currentType===2">单选题</text>
				<text v-else-if="currentType===3">多选题</text>
				<text v-else-if="currentType===4">填空题</text>
				<text v-else-if="currentType===5">问答题</text>
			</view>
			
			<view class="action">
				<button class="cu-btn bg-green shadow" @tap="showCardModal" data-target="modalCard">答题卡</button>
				<button v-if="isFinished!=true" class="cu-btn bg-blue shadow margin-left" @tap="showModal" data-target="DialogModal2">交卷</button>
<!-- 				<button class="cu-btn bg-cyan shadow" style="margin-left: 10px;" @click="mySubmit()">交卷</button> -->
			</view>
		</view>
		<view class="cu-modal" :class="modalCard=='modalCard'?'show':''" @tap="hideCardModal">
			<view class="cu-dialog" @tap.stop>

				<scroll-view class="page padding" :scroll-y=true :style="{'height':swiperHeight}">
					<view class="cu-bar solid-bottom">
						<view class="action">
							<text class="cuIcon-title text-red"></text>答题卡
						</view>
					</view>
					<view class="grid col-5 ">
						<view class="margin-tb-sm text-center" v-for="(subject,index) in subjectList" :key="index">
							<!-- 未完成交卷 -->
							<button v-if="isFinished==true" class="cu-btn round" :class="[subject.userAnswer == subject.answer?'bg-blue':'bg-red']"
								@click="AppointedSubject(index)">{{index+1}}</button>
							<!-- 完成交卷 -->
							<button v-else class="cu-btn round" :class="[subject.userAnswer.length===0?'line-grey':'bg-blue']"
								@click="AppointedSubject(index)">{{index+1}}</button>
						</view>
					</view>

				</scroll-view>
			</view>
		</view>
		<view class="cu-modal padding " :class="modalError=='modalError'?'show':''" @tap="hideErrorModal">
			<view class="cu-dialog bg-white" @tap.stop>

				<view class="cu-bar solid-bottom ">
					<view class="action">
						<text class="cuIcon-title text-red"></text>试题纠错
					</view>
				</view>

				<radio-group class="block">
					<view class="cu-list menu text-left">
						<view class="cu-item cu-item-error" v-for="error in errorList">
							<radio :value="error"></radio>
							<view class="title text-black margin-left">{{error}}</view>
						</view>
					</view>
				</radio-group>

				<view class="padding flex flex-direction ">
					<button class="cu-btn bg-red margin-tb-sm lg" @click="SubmitError">提 交</button>
				</view>
			</view>
		</view>
		<form>
			<swiper :current="subjectIndex" class="swiper-box" @change="SwiperChange" :style="{'height':swiperHeight}">
				<swiper-item v-for="(subject,index) in subjectList">

					<view v-if="index-subjectIndex>=-1&&index-subjectIndex<=1">

						<view class="cu-bar bg-white solid-bottom">
							<view class="action text-black">
								<text class="cuIcon-title text-red"></text>{{index+1}}．{{subject.title}}
							</view>
						</view>
						<view>

							<radio-group class="block" @change="RadioboxChange"
								v-if="subject.type===1||subject.type===2">
								<view class="cu-form-group" v-for="option in subject.optionList">
									<!-- disabled添加禁选 -->
									<radio :disabled="isFinished==true?true:false" :value="option.id"
										:checked="subject.userAnswer.indexOf(option.id) > -1?true:false"></radio>
									<view class="title text-black">{{option.id}}.{{option.content}}</view>
									<!-- 显示错误或者对图标 -->
									<view v-if="isFinished==true && subject.userAnswer == subject.answer && subject.userAnswer.indexOf(option.id) > -1?true:false" class="title cuIcon-roundcheckfill text-blue">对</view>
									<view v-else-if="isFinished==true && subject.userAnswer != subject.answer && subject.userAnswer.indexOf(option.id) > -1?true:false" class="title cuIcon-roundclosefill text-red">错</view>
								</view>
							</radio-group>

							<checkbox-group class="block" @change="CheckboxChange" v-else-if="subject.type===3">
								<view class="cu-form-group" v-for="option in subject.optionList">
									<checkbox :value="option.id"
										:class="subject.userAnswer.indexOf(option.id) > -1?'checked':''"
										:checked="subject.userAnswer.indexOf(option.id) > -1?true:false"></checkbox>
									<view class="title  text-black">{{option.id}}.{{option.content}}</view>
								</view>
							</checkbox-group>

							<view v-else-if="subject.type===4">
								<view class="cu-form-group solid-bottom">
									<view class="title  text-black">
										答：
									</view>
									<input placeholder="文本输入框" name="input" v-model="subject.userAnswer"
										@blur="textInput"></input>
								</view>
							</view>

							<view v-else-if="subject.type===5">
								<view class="cu-bar cu-bar-title bg-white margin-top">
									<view class="action  text-black">
										答：
									</view>
								</view>
								<view class="cu-form-group solid margin">
									<textarea maxlength="-1" @blur="textInput" v-model="subject.userAnswer"
										placeholder="多行文本输入框"></textarea>
								</view>
							</view>

						</view>

						<view v-show="subject.showAnswer" class="margin-top solid-top">
							<view class="cu-bar">
								<view class="action  text-grey">
									<text>正确答案：</text>
									<text class="solid-bottom  padding-left text-green">{{subject.answer}}</text>
								</view>
							</view>
							<view class="cu-bar cu-bar-title">
								<view class="action  text-grey">
									<text>解析：</text>
								</view>
							</view>
							<view class="text-content padding  text-grey">
								{{subject.explain}}
							</view>
						</view>

					</view>
				</swiper-item>
			</swiper>
		</form>
		<view id="foot-box" class="cu-bar tabbar bg-white shadow foot">
			<view class="action" @click="MoveSubject(-1)">
				<view class="cuIcon-cu-image">
					<text class="lg cuIcon-back text-gray"></text>
				</view>
				<view class="text-gray">上一题</view>
			</view>
			<view class="action" @click="MoveSubject(1)">
				<view class="cuIcon-cu-image">
					<text class="lg text-gray cuIcon-right"></text>
				</view>
				<view class="text-gray">下一题</view>
			</view>

			<view v-if="isFinished==true" class="action" @click="FavorSubject">
				<view class="cuIcon-cu-image">
					<text class="lg cuIcon-favor" :class="[userFavor?'text-red':'text-gray']"></text>
				</view>
				<view :class="[userFavor?'text-red':'text-gray']">收藏</view>
			</view>

			<view class="action" @click="ShowAnswerChange">
				<view class="cuIcon-cu-image">
					<text class="lg text-gray cuIcon-question"></text>
				</view>
				<view class="text-gray">解答</view>
			</view>
			<view class="action" @tap="showErrorModal" data-target="modalError">
				<view class="cuIcon-cu-image">
					<text class="lg text-gray cuIcon-warn"></text>
				</view>
				<view class="text-gray">纠错</view>
			</view>

		</view>


		<!-- 对话框 -->
		<view class="cu-modal" :class="modalName=='DialogModal2'?'show':''">
			<view class="cu-dialog">
				<view class="cu-bar bg-white justify-end">
					<view class="content">提交答题卡</view>
					<view class="action" @tap="hideModal">
						<text class="cuIcon-close text-red"></text>
					</view>
				</view>
				
				
				<view class="flex-sub text-center">
					<view class="solid-bottom text-xs padding">
						<text class="text-red cuIcon-info">是否确认提交答题卡</text>
					</view>
				</view>
				
<!-- 				<view class="padding-xl">
					<view class="action margin-0 flex-sub text-red solid-left cuIcon-info">是否确认提交答题卡</view>
				</view> -->
				
				<view class="cu-bar bg-white">
					<view class="action margin-0 flex-sub text-green " @tap="mySubmit()">
						<!-- <text class="cuIcon-squarecheck"></text>交卷 -->
						<button class="cu-btn bg-red margin-tb-sm lg">交卷</button>
						</view>
					<view class="action margin-0 flex-sub text-green solid-left" @tap="hideModal">
						<button class="cu-btn bg-blue margin-tb-sm lg">返回</button>
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
				modalName: null,
				isFinished: true,
				userFavor: false, //是否已收藏
				currentType: 0, //当前题型
				subjectIndex: 0, //跳转索引
				autoShowAnswer: false, //答错是否显答案
				autoRadioNext: true, //判断题、单项题，自动移下一题
				swiperHeight: '800px', //
				title: '补概试题',
				subjectList: [
					// {
					// 	"title":"1．（2001年数学四）对于任意两个事件A和B,与AUB=B不等价的是（  ）",	//标题
					// 	"type":1,				//判断题
					// 	"optionList":[
					// 		{"id":"A",			//选项A
					// 		"content":"对",		//选项A内容
					// 		},
					// 		{"id":"B",			//选项B
					// 		"content":"错",		//选项B内容
					// 		}],
					// 	"answer":"A",			//正确答案
					// 	"userAnswer":"",		//用户选择的答案，后面表单提交时用到
					// 	"userFavor":false,		//用户是否收藏改题
					// 	"explain":"难到是固体不成？",		//题目解析
					// },
					{
						"title": "（2001年数学四）对于任意两个事件A和B,与AUB=B不等价的是（  ）", //标题
						"type": 2, //单选题
						"optionList": [{
								"id": "A", //选项A
								"content": "A ⊂ B", //选项A内容
							},
							{
								"id": "B", //选项B
								"content": "¬B ⊂ ¬A", //选项B内容
							},
							{
								"id": "C", //选项C
								"content": "A¬B = φ", //选项C内容
							},
							{
								"id": "D", //选项C
								"content": "¬AB = φ", //选项C内容
							},
						],
						"answer": "D", //正确答案
						"userAnswer": "", //用户选项
						"userFavor": false, //是否收藏
						"explain": "【解题分析】本题主要考察事件的关系与运算. 可利用文氏图进行分析,正确答案为D", //答案解析
					},

					{
						"title": "（1987年数学三）设为A、B两事件且P(AB)=0,则(   ).", //标题
						"type": 2, //多选题
						"optionList": [{
								"id": "A", //选项A
								"content": "A与B互斥",
							},
							{
								"id": "B", //选项B
								"content": "AB是不可能事件",
							},
							{
								"id": "C", //选项C
								"content": "AB未必是不可能事件",
							},
							{
								"id": "D", //选项D
								"content": "P(A)=0或P(B)=0",
							}
						],
						"answer": "C", //正确选项
						"userAnswer": "",
						"userFavor": false, //是否收藏
						"explain": "解：这里考查的是概率为0的事件与不可能事件之间的关系.必须注意,不可能事件的概率为零,但事件为零的概率不一定是不可能事件.比如连续型随机变量取任何给定实数值的概率都等于0.所以P(AB)=0,AB未必是不可能事件．所以正确答案是C.", //答案解析
					},


					{
						"title": "（1989年数学三、四）以A表示事件“甲种产品畅销，乙种产品滞销”，则其对立¬A事件为（  ）．", //标题
						"type": 2, //多选题
						"optionList": [{
								"id": "A", //选项A
								"content": "甲种产品滞销，乙种产品畅销”",
							},
							{
								"id": "B", //选项B
								"content": "甲、乙两种产品均畅销",
							},
							{
								"id": "C", //选项C
								"content": "甲种产品滞销",
							},
							{
								"id": "D", //选项D
								"content": "甲种产品滞销或乙种产品畅销",
							}
						],
						"answer": "D", //正确选项
						"userAnswer": "",
						"userFavor": false, //是否收藏
						"explain": "【解题分析】要想正确解答本题,只需把问题转化为事件,然后利用事件之间的关系求解即可.设B＝“甲种产品滞销”，C＝“乙种产品畅销”，则由题设A=BC，于是对立事件¬A为:¬A=¬(BC)=¬BU¬C=“甲种产品滞销或乙种产品畅销”,所以正确答案是D．", //答案解析
					}
				],
				modalCard: null, //显示答题卡
				modalError: null, //纠错卡
				errorList: ['题目不完整', '答案不正确', '含有错别字', '图片不存在', '解析不完整', '其他错误']
			}
		},
		onReady() {

			var tempHeight = 800;
			var _me = this;
			uni.getSystemInfo({
				//获取手机屏幕高度信息，让swiper的高度和手机屏幕一样高                
				success: function(res) {
					// console.log(res.model);                    
					// console.log(res.pixelRatio);                    
					// console.log(res.windowWidth);                    
					// console.log(res.windowHeight);
					// //这里是手机屏幕高度                    
					// console.log(res.language);                    
					// console.log(res.version);                    
					// console.log(res.platform);                    
					tempHeight = res.windowHeight;
					console.log("屏幕可用高度 " + tempHeight);

					uni.createSelectorQuery().select("#top-box").fields({
						size: true,
						scrollOffset: true
					}, (data) => {
						tempHeight -= data.height;
						console.log("减掉顶部后的高度 " + tempHeight);

						uni.createSelectorQuery().select("#foot-box").fields({
							size: true,
							scrollOffset: true
						}, (data) => {
							tempHeight -= data.height;
							console.log("减掉底部后的高度 " + tempHeight);
							_me.swiperHeight = tempHeight + 'px';
							console.log("滑屏最后高度 " + _me.swiperHeight);
						}).exec();

					}).exec();
				}
			});

		},
		onLoad() {

			this.currentType = this.subjectList[0].type;
			uni.setNavigationBarTitle({
				title: this.title
			});

			//添加用户显示答案字段
			for (var i = 0; i < this.subjectList.length; i++) {
				this.$set(this.subjectList[i], "showAnswer", false);
			}

		},
		methods: {
			// //确认提交作业
			// toSubmit(){

			// },
			//隐藏对话框
			hideModal(e) {
				console.log("我是返回")
				this.modalName = null
			},
			// 展示对话框
			showModal(e) {
				this.modalName = e.currentTarget.dataset.target
			},
			mySubmit(){
				// uni.showToast({
				// 	title: '请交卷后再查看解析',
				// 	icon: 'none',  // 不显示图标
				// 	duration: 1500
				// });
				this.modalName = null
				console.log("提交试卷")
				this.isFinished = true
				for (var i = 0; i < this.subjectList.length; i++) {
					console.log("输出长度")
					console.log(JSON.stringify(this.subjectList[i].userAnswer))
					// if(){
						
					// }
					// JSON.stringify(object)

				}
				
			},
			showCardModal: function(e) {
				this.modalCard = e.currentTarget.dataset.target
			},
			hideCardModal: function(e) {
				this.modalCard = null
			},
			showErrorModal: function(e) {
				this.modalError = e.currentTarget.dataset.target
			},
			hideErrorModal: function(e) {
				this.modalError = null
			},
			SwiperChange: function(e) { //滑动事件

				let index = e.target.current;

				if (index != undefined) {
					this.subjectIndex = index;
					this.currentType = this.subjectList[index].type;
					this.userFavor = this.subjectList[index].userFavor;
				}
			},
			RadioboxChange: function(e) { //单选选中
				var items = this.subjectList[this.subjectIndex].optionList;
				var values = e.detail.value;
				this.subjectList[this.subjectIndex].userAnswer = values;
				if (this.autoRadioNext && this.subjectIndex < this.subjectList.length - 1) {
					this.subjectIndex += 1;
				};

			},
			CheckboxChange: function(e) { //复选选中

				var items = this.subjectList[this.subjectIndex].optionList;
				var values = e.detail.value;
				this.subjectList[this.subjectIndex].userAnswer = "";
				for (var i = 0, lenI = items.length; i < lenI; ++i) {
					for (var j = 0, lenJ = values.length; j < lenJ; ++j) {
						if (items[i].id == values[j]) {

							this.subjectList[this.subjectIndex].userAnswer += items[i].id;
							break
						}
					}
				}
			},
			textInput: function(e) { //填空题

				this.subjectList[this.subjectIndex].userAnswer = e.detail.value;

			},
			ShowAnswerChange: function(e) { //显示答案
				if(this.isFinished == false){
					uni.showToast({
						title: '请交卷后再查看解析',
						icon: 'none',  // 不显示图标
						duration: 1500
					});
					return;
				}

				if (this.subjectList[this.subjectIndex].showAnswer) {
					this.subjectList[this.subjectIndex].showAnswer = false;
				} else {

					this.subjectList[this.subjectIndex].showAnswer = true;
				}
			},

			FavorSubject: function(e) { //收藏题

				if (this.userFavor) {
					this.userFavor = false;
					this.subjectList[this.subjectIndex].userFavor = false;
				} else {

					this.userFavor = true;
					this.subjectList[this.subjectIndex].userFavor = true;
				}
			},

			MoveSubject: function(e) { //上一题、下一题

				if (e === -1 && this.subjectIndex != 0) {
					this.subjectIndex -= 1;
				}
				if (e === 1 && this.subjectIndex < this.subjectList.length - 1) {
					this.subjectIndex += 1;
				}
			},

			AppointedSubject: function(e) { //题卡指定

				this.modalCard = null;
				this.subjectIndex = e;
			},

			SubmitError: function(e) { //提交纠错
			console.log("纠错")
				this.modalError = null;
			}

		}
	}
</script>

<style>
	@import "../../../colorui/animation.css";

	page {
		background-color: #FFFFFF;
	}

	.cu-form-group {
		justify-content: flex-start
	}

	.cu-form-group .title {
		padding-left: 30upx;
		padding-right: 0upx;
	}

	.cu-form-group+.cu-form-group {
		border-top: none;
	}

	.cu-bar-title {
		min-height: 50upx;
	}

	.cu-list.menu>.cu-item-error {
		justify-content: flex-start;
	}
</style>
