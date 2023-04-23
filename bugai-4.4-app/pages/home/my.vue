<template>
	<view class="my">
<!-- 		<acqui-dynamic-message
			ref="dynamicMessage"
			:showTime="parseFloat(showTime) || 3"
			:hideTime="parseFloat(hideTime) || 2"
			:messagePosition="messagePosition"
			:animalType="animalType"
			:messageCusPosition="messageCusPosition"
			:messageList="messageList"
			:isFixed="isFixed"
		></acqui-dynamic-message> -->
		<image src="/static/imgs/my-bg4.png" mode="aspectFill" class="my_bg"></image>
		<view class="header_cell">
			<view class="user_info">
				<view class="flex justify-center align-center">
					<image :src="avatar" mode="aspectFill" class="user_photo"></image>
					<view>
						<view class="text-black text-bold">
							<text class="text-xl" style="font-weight: bold;">{{userInfo.nickname}}</text>
							<text class="cu-tag round bg-red" style="margin-left: 20rpx;">{{userInfo.rnameZh}}</text>
						</view>
						<view class="text-grey">
							<span>账号：</span>
							<span>{{userInfo.username}}</span>
						</view>
					</view>
				</view>
				<text class="lg text-gray cuIcon-right"></text>
			</view>
			<view class="auth_btn">
				<button class="cu-btn round bg-black" @click="out()">
					<text class="lg text-white cuIcon-exit" style="margin-right: 20rpx;"></text>
					退出登录
				</button>
			</view>

			<view class="vip_cell flex justify-between align-center">
				<view>
					<view class="text-xl" style="font-weight: bold;color: rgb(241, 198, 142);">
						0 概片
						<text class="lg cuIcon-vip" style="margin-left: 15rpx;"></text>
					</view>
					<view class="text-xs" style="margin-top: 10rpx;">该功能目前暂未开放</view>
				</view>
				<button class="cu-btn round invate_btn">概片</button>
			</view>
		</view>

		<view class="cell_1 flex justify-around align-center bg-white mt30"
			style="padding: 30rpx 0;border-radius: 15rpx;text-align: center;">
			<view @tap="showModal" data-target="DialogModal2">
				<view class="cell_1_icon flex justify-center align-center"><text
						class="text-gray cuIcon-refresh"></text></view>
				<view>加入班级</view>

			</view>
			<view @click="youxiang()">
				<view class="cell_1_icon flex justify-center align-center"><text
						class="text-gray cuIcon-settings"></text></view>
				<view>绑定邮箱</view>
			</view>
			<view @click="xiugaimima()">
				<view class="cell_1_icon flex justify-center align-center"><text class="text-gray cuIcon-full"></text>
				</view>
				<view>修改密码</view>
			</view>
		</view>

		<view class="cell_2 flex justify-between align-center mt30">
			<view @click="tiku()">
				<view class="cell_2_icon flex justify-center align-center"><text class="text-olive cuIcon-list"></text>
				</view>
				<view>查看题库</view>
			</view>
			<view @click="myDynamicDetails()">
				<view class="cell_2_icon flex justify-center align-center"><text class="text-cyan cuIcon-form"></text>
				</view>
				<view>我的动态</view>
			</view>
		</view>

		<view class="mt30 grid text-center col-4 bg-white"
			style="padding: 30rpx 0; border-radius: 15rpx;row-gap: 30rpx;">
			<view @click="help()">
				<view class="cell_3_icon flex justify-center align-center"><text
						class="text-cyan cuIcon-hotfill"></text></view>
				<view>帮助文档</view>
			</view>
			<view @click="update()">
				<view class="cell_3_icon flex justify-center align-center"><text
						class="text-cyan cuIcon-explorefill"></text></view>
				<view>检查更新</view>
			</view>
			
			<view @click="about()">
				<view class="cell_3_icon flex justify-center align-center"><text
						class="text-olive cuIcon-friendfamous"></text></view>
				<view>关于</view>
			</view>
			
			<!-- 			<view>
				<view class="cell_3_icon flex justify-center align-center"><text class="text-cyan cuIcon-similar"></text></view>
				<view>发现壁纸</view>
			</view>
			<view>
				<view class="cell_3_icon flex justify-center align-center"><text class="text-cyan cuIcon-vipcard"></text></view>
				<view>甜蜜修勾</view>
			</view>
			<view>
				<view class="cell_3_icon flex justify-center align-center"><text class="text-cyan cuIcon-barcode"></text></view>
				<view>甜蜜修勾</view>
			</view>
			<view>
				<view class="cell_3_icon flex justify-center align-center"><text class="text-cyan cuIcon-upstagefill"></text></view>
				<view>甜蜜修勾</view>
			</view>
			<view>
				<view class="cell_3_icon flex justify-center align-center"><text class="text-cyan cuIcon-clothesfill"></text></view>
				<view>甜蜜修勾</view>
			</view> -->
		</view>

		<!-- 		<view class="cell_4 mt30 bg-white" style="padding:40rpx 30rpx; border-radius: 15rpx;">
			<view class="flex justify-between align-center">
				<view class="flex justify-center align-center">
					<text class="text-gray cuIcon-repair" style="margin-right: 20rpx;font-size: 40rpx;"></text>
					<text>更新日志</text>
				</view>
				<text class="lg text-gray cuIcon-right"></text>
			</view>
			<view class="flex justify-between align-center">
				<view class="flex justify-center align-center">
					<text class="text-gray cuIcon-hot" style="margin-right: 20rpx;font-size: 40rpx;"></text>
					<text>帮助文档</text>
				</view>
				<text class="lg text-gray cuIcon-right"></text>
			</view>
			<view class="flex justify-between align-center">
				<view class="flex justify-center align-center">
					<text class="text-gray cuIcon-crown" style="margin-right: 20rpx;font-size: 40rpx;"></text>
					<text>使用协议</text>
				</view>
				<text class="lg text-gray cuIcon-right"></text>
			</view>
			<view class="flex justify-between align-center">
				<view class="flex justify-center align-center">
					<text class="text-gray cuIcon-musicfill" style="margin-right: 20rpx;font-size: 40rpx;"></text>
					<text>使用协议</text>
				</view>
				<text class="lg text-gray cuIcon-right"></text>
			</view>
		</view> -->

		<!-- 		<view class="cell_4 mt30 bg-white" style="padding:40rpx 30rpx; border-radius: 15rpx;">
			<view class="flex justify-between align-center">
				<view class="flex justify-center align-center">
					<text class="text-gray cuIcon-weixin" style="margin-right: 20rpx;font-size: 40rpx;"></text>
					<text>联系客服</text>
				</view>
				<text class="lg text-gray cuIcon-right"></text>
			</view>
			<view class="flex justify-between align-center">
				<view class="flex justify-center align-center">
					<text class="text-gray cuIcon-formfill" style="margin-right: 20rpx;font-size: 40rpx;"></text>
					<text>提交反馈</text>
				</view>
				<text class="lg text-gray cuIcon-right"></text>
			</view>
			<view class="flex justify-between align-center">
				<view class="flex justify-center align-center">
					<text class="text-gray cuIcon-dianhua" style="margin-right: 20rpx;font-size: 40rpx;"></text>
					<text>技术支持</text>
				</view>
				<text class="cu-tag radius sm">177****3698</text>
			</view>
			<navigator class="flex justify-between align-center" open-type="navigateBack" :delta="1">
				<view class="flex justify-center align-center">
					<text class="text-gray cuIcon-formfill" style="margin-right: 20rpx;font-size: 40rpx;"></text>
					<text>返回上一页</text>
				</view>
				<text class="lg text-gray cuIcon-right"></text>
			</navigator>
		</view> -->

		<!-- 加入班级对话框 -->
		<view class="cu-modal" :class="modalName=='DialogModal2'?'show':''">
			<view class="cu-dialog">
				<view class="cu-bar bg-white justify-end">
					<view class="content">加入新班级</view>
					<view class="action" @tap="hideModal">
						<text class="cuIcon-close text-red"></text>
					</view>
				</view>

				<view class="main">
					<view class="bg-white margin-top" style="padding-bottom: 20rpx;">
						<view class="cu-bar bg-white solid-bottom">
							<view class='action'>
								<text class='cuIcon-title text-blue'></text>请输入班级号
							</view>
						</view>
						<view style="width: 500rpx;margin: 20rpx auto;font-size: 50rpx;font-weight: bold;">
							<verification-code-style2 borderStyle="border:1px solid gray"
								borderCheckStyle="border:1px solid blue"
								@inputVerificationChange="inputVerificationChange"></verification-code-style2>
						</view>
					</view>
				</view>
				

				<view class="cu-bar bg-white">
					<view class="action margin-0 flex-sub text-green " @tap="myClass()">
						<!-- <text class="cuIcon-squarecheck"></text>加入新班级 -->
						<button class="cu-btn bg-blue margin-tb-sm lg">加入</button>
					</view>
					<view class="action margin-0 flex-sub text-green solid-left" @tap="hideModal">
					<button class="cu-btn bg-red margin-tb-sm lg">返回</button>
					</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	import verificationCodeStyle2Vue from '../../components/verification-code-style2/verification-code-style2.vue'
	export default {
		data() {
			return {
				avatar: "/static/tabbar/about.png",
				//显示框
				showTime: 3,
				hideTime: 60,
				messagePosition: 'rightTop',
				animalType: 1,
				messageList: [
					{
						photo: '/static/1024x1024.png', //用户头像
						text: '欢迎使用补概app！😀😀' //文本
					}
				],
				messageCusPosition: '',
				isFixed: false,
				//显示框
				modalName: null,
				classId: null,
				userInfo: {
					nickname: "游客",
					username: "游客",
					rnameZh: "游客",
					email: null
				}
			};
		},
		mounted() {
			this.getUserInfo()
		},
		methods: {

			//获取用户信息
			getUserInfo(){
				this.request({
					url: "/user/info",
					method: "POST"
				}).then(resp=>{
					console.log(resp)
					console.log("用户信息")
					if(resp.code == 200){
						console.log("用户信息")
						this.userInfo.nickname = ""
						this.userInfo.username = ""
						this.rnameZh = ""
						this.email = null
						let nickname = resp.data.nickname
						let rnameZh = resp.data.rnameZh
						let username = resp.data.username
						let email = resp.data.email
						let Iavatar = resp.data.avatar
						// 这里先拿出来,后面再改进
						this.userInfo.nickname = nickname
						this.userInfo.username = username
						this.userInfo.rnameZh = rnameZh 
						this.userInfo.email = email

						if(Iavatar != null && Iavatar != ""){
							this.avatar = Iavatar
						}
					}
				})
			},
			/*绑定邮箱*/
			youxiang(){
				// 查看是否绑定过邮箱
				console.log("yoxiang")
				if(this.userInfo.email != null || this.userInfo.email != ''){
					this.request({
						url: "/isRegisteredEmail",
						method: "POST",
						data: {
							email: this.userInfo.email
						}
					}).then(resp=>{
						if(resp.code == 200){
							console.log("已经注册过")
							uni.showToast({
								title: "已经绑定过邮箱！",
								icon: 'none',
								duration: 1500
							})
							return;
						}
						console.log(this.userInfo.email)
						console.log("没有注册过")
						uni.navigateTo({
							url: '/pages/signup/email'
						})
					})
					return;
				}
				
				uni.navigateTo({
					url: '/pages/signup/email'
				})
			},
			/*加入班级--begin--*/
			getVal(){
				const val= this.$refs.verificationCodeStyle2.getValue()
				uni.showModal({
					content:"获取到值："+val,
					showCancel:false
				})
			},
			clearVal(){
				this.$refs.verificationCodeStyle2.cleanVal()
			},
			setVal(){
				this.$refs.verificationCodeStyle2.setVerificationCode('888')
			},
			inputVerificationChange(val){
				console.log('值改变了：'+val);
				this.classId = val
			},
			/*加入班级--end--*/
			//提交班级
			myClass(){
				var that = this
				console.log("加入班级")
				console.log(this.classId)
				
				if(this.classId.length!=4){
					uni.showToast({
						title: '输入长度有误，请重新输入！',
						icon: 'none',  // 不显示图标
						duration: 1500
					});
				}else{
					that.request({
						url: "/class/userClass",
						method: "POST",
						data: {
							name: that.classId
						}
					}).then(resp=>{
						console.log(resp)
						if(resp.code == 200){
							uni.showToast({
								title: '加入班级成功！',
								icon: 'none',  // 不显示图标
								duration: 1500
							});
							that.modalName = null
						}else{
							uni.showToast({
								title: '加入班级失败，请确认班级号是否正确！',
								icon: 'none',  // 不显示图标
								duration: 1500
							});
						}
					})
				}
			},
			//隐藏对话框
			hideModal(e) {
				console.log("我是返回")
				this.modalName = null
			},
			// 展示对话框
			showModal(e) {
				console.log("加入班级")
				this.request({
					url: "/class/is",
					method: "GET"
				}).then(resp=>{
					if(resp.code == 200){
						this.modalName = e.currentTarget.dataset.target
					}else if(resp.code == 500){
						uni.showToast({
							icon: 'none',
							title: '你已经加入过班级，无需再操作！',
							duration: 2000
						});
					}else{
						uni.showToast({
							icon: 'none',
							title: '内部系统错误，请联系管理员或者老师！',
							duration: 2000
						});
					}
				})
			},
			// getUserInfo() {
			// 	var that = this
			// 	this.request({
			// 		url: "/user/info",
			// 		method: "POST"
			// 	}).then(resp => {
			// 		console.log(resp)
			// 		if (resp.code == 200) {
			// 			that.uid = resp.data.uid
			// 			that.name = resp.data.nickname
			// 		}
			// 	})
			// },
			tiku() {
				uni.navigateTo({
					url: '/pages/examination/exam_list'
				})
			},
			xiugaimima() {
				uni.navigateTo({
					url: '/pages/signup/forget'
				})
				console.log("tem")
			},
			myDynamicDetails(){
				uni.navigateTo({
					url: "/pages/myDynamic/myDynamic"
				})
				// uni.showToast({
				// 	 icon: 'none',
				// 	title: '该功能将在下个版本上线',
				// 	duration: 2000
				// });
			},
			update() {
				// uni.showToast({
				// 	 icon: 'none',
				// 	title: '目前已经是最新',
				// 	duration: 2000
				// });
				uni.navigateTo({
					url: '/pages/appUpdate/appUpdate'
				})
				// console.log("tem")
			},
			help() {
				// uni.showToast({
				// 	 icon: 'none',
				// 	title: '功能正在开发中',
				// 	duration: 2000
				// });
				uni.navigateTo({
					url: "/pages/helpDocument/helpDocument"
				})
			},
			about() {
				uni.navigateTo({
					url: '/pages/teamInfo/teamInfo'
				})
				// uni.showToast({
				// 	icon: 'none',
				// 	title: '该功能将在下个版本上线',
				// 	duration: 2000
				// });
			},
			out() {
				uni.setStorageSync("JWT", "")
				uni.navigateTo({
					url: '/pages/signup/index'
				})
			}
		},
		components:{
			verificationCodeStyle2Vue
		}
	};
</script>

<style lang="less" scoped>
	.my {
		padding: 30rpx;

		.mt30 {
			margin-top: 30rpx;
		}

		.my_bg {
			position: absolute;
			left: 0;
			top: 0;
			z-index: -1;
			width: 100%;
		}

		.header_cell {
			margin-top: 100rpx;

			.user_info {
				display: flex;
				justify-content: space-between;
				align-items: center;

				.user_photo {
					width: 120rpx;
					height: 120rpx;
					box-shadow: 0px 0px 10rpx 1px rgba(0, 0, 0, 0.1);
					border-radius: 50%;
					background-color: white;
					margin-right: 20rpx;
				}
			}

			.auth_btn {
				margin: 50rpx auto;
				text-align: center;

				&>button {
					box-shadow: 3px 3px 10rpx 1px rgba(0, 0, 0, 0.2);
					padding-left: 50rpx;
					padding-right: 50rpx;
				}
			}

			.vip_cell {
				margin-top: 40rpx;
				width: 690rpx;
				height: 150rpx;
				background-image: url('/static/imgs/vip_bg.png');
				background-size: 100% 100%;
				color: white;
				padding: 0 30rpx;

				.invate_btn {
					background-color: rgb(241, 198, 142);
					box-shadow: 3px 3px 10rpx 1px rgba(241, 198, 142, 0.5);
					width: 150rpx;
					color: rgb(99, 71, 56);
					font-weight: bold;
				}
			}
		}

		.cell_1_icon {
			width: 100rpx;
			height: 100rpx;
			background-color: #f4f2f7;
			border-radius: 50%;
			font-size: 50rpx;
			margin: 0 auto;
			margin-bottom: 15rpx;
		}

		.cell_2 {
			&>view {
				background-color: white;
				border-radius: 15rpx;
				text-align: center;
				width: 48%;
				padding: 30rpx 0;
			}

			.cell_2_icon {
				font-size: 60rpx;
				margin-bottom: 15rpx;
			}
		}

		.cell_3_icon {
			font-size: 50rpx;
			margin-bottom: 20rpx;
		}

		.cell_4 {

			&>view,
			navigator {
				padding: 20rpx 0;
			}
		}
	}
</style>