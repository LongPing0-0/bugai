<template>
	<view>
		<view class="cu-card dynamic" :class="isCard?'no-card':''" style="margin-bottom: 14px;">
			<view class="cu-item shadow">
				<view class="cu-list menu-avatar">
					<view class="cu-item">
						<!-- 头像 -->
						<view class="cu-avatar round lg"
							:style="changeAvatar(dataList.avatar)">
						</view>

						<view class="content flex-sub">
							<!-- 姓名 -->
							<view>{{dataList.nickname}}</view>
							<!-- 发布时间 -->
							<view class="text-gray text-sm flex justify-between">
								{{dataList.created}}
							</view>
						</view>
					</view>
				</view>

				<view class="text-content">
					<view class="margin-top-xs" v-html="dataList.content"></view>
				</view>

				<view class="text-gray  text-right padding">
					<!-- <text class="cuIcon-attentionfill margin-lr-xs"></text> 10 -->
					<!-- 点赞人数 -->
					<text class="cuIcon-appreciatefill margin-lr-xs">{{dataList.favorCount}}</text>
					<!-- 评论人数 -->
					<text class="cuIcon-messagefill margin-lr-xs">{{dataList.commentCount}}</text>
				</view>
			</view>

		</view>

		<!-- 评论？ -->
		<view class="cu-card dynamic" :class="isCard?'no-card':''">


			<view class="cu-item shadow">
				<!-- 评论 -->
				<view class="cu-list menu-avatar comment solids-top">
					<view class="cu-bar" style="margin-left: 10rpx;">
						<view class="text-gray text-left">{{dataList.commentCount}}条评论</view>
					</view>
					
					
					<view v-if="commentList.length == 0" class="padding text-center" style="height: auto;">
						<view class="padding-lr bg-white margin-top">
							<view class="solid-bottom padding">
								<text class="text-ABC">bugai</text>
							</view>
							<view class="padding">当前0条评论，快来发表吧！</view>
						</view>
					</view>
					

					
					<view v-for="(item,index) in commentList" class="cu-item">
						<view class="cu-avatar round"
						:style="changeAvatar(item.avatar)">
						</view>
						<view class="content">
							<view class="text-gray">
								<text>{{item.nickname}}</text>
							</view>
							<view class="bg-grey padding-sm radius margin-top-sm  text-sm">
								<view class="flex">
									<view class="flex-sub">{{item.content}}</view>
								</view>
							</view>
							<view class="margin-top-sm flex justify-between">
								<view class="text-gray text-df">{{item.commentTime}}</view>
								<view v-if="item.uid == userInfo.uid || userInfo.rid == 4"><button
										class="cuIcon-delete text-gray" @click="deleteComment(item.id)"></button></view>
							</view>
						</view>
					</view>


					<!-- start -->
				</view>

			</view>



		</view>

		<!--提示框-->
		<view class="cu-modal" :class="tanchuang?'show':''">
			<view class="cu-dialog">
				<view class="padding-xl text-gray text-left bg-white">
					确定要删除这条信息吗？
				</view>
				<view class="cu-bar bg-white justify-end">
					<view class="action">
						<button class="cu-btn line-green text-green" @tap="closeTanchuang()">取消</button>
						<button class="cu-btn bg-green margin-left" @tap="trueTanchuang()">确定</button>

					</view>
				</view>
			</view>
		</view>

		<!-- 触底 -->
		<view v-if="isChudi" class="cu-load bg-grey" :class="!isLoad?'loading':'over'"></view>

		<!-- 底部操作条 -->
		<view v-if="pinglun ==false" class="comment_public cu-bar search bg-white"
			style="position:fixed;bottom: 0rpx;margin:;width: 100%;">

			<view class="action" style="margin-left: 45rpx;">
				<view class="cuIcon-share">
					<text style="margin-left: 10rpx;" @click="shareP()">分享</text>
				</view>
			</view>
			<view class="action" @click="isPinglun()">
				<view class="cuIcon-markfill">
					<text style="margin-left: 10rpx;">评论</text>
				</view>
			</view>
			<view class="action" @click="dianzang()">
				<view v-if="isfavored == true" class="cuIcon-appreciatefill">
					<text style="margin-left: 10rpx;">{{dataList.favorCount}}</text>
				</view>
				<view v-else class="cuIcon-appreciate">
					<text style="margin-left: 10rpx;">{{dataList.favorCount}}</text>
				</view>

			</view>
		</view>

		<view v-if="pinglun" class="comment_public cu-bar search bg-white"
			style="position:fixed;bottom: 0rpx;width: 100%;">

			<view class="search-form round">
				<text class="cuIcon-edit lg text-gray"></text>
				<input v-model="inputValue" type="text" placeholder="我也来说两句..." confirm-type="search"></input>
			</view>
			<view class="action">
				<view class="cuIcon-close" style="margin-right: 10rpx;" @click="closePinglun()"></view>
				<button @click="publishComment()" class="cu-btn shadow-blur round"
					style="width: 120rpx;color: white;background-color: rgb(228, 169, 60);font-size: 30rpx;text-align: center;">
					<text>发表</text></button>

			</view>
		</view>
		<!-- 				style=""{{guide_comment?'width: 120rpx;color: white;background-color: rgb(228, 169, 60);font-size: 30rpx;text-align: center;':'width: 120rpx;color: white;background-color: rgb(190, 190, 190);font-size: 30rpx;text-align: center;'}} -->


	</view>
</template>

<script>
	export default {
		data() {
			return {
				limitComment: 3,
				inputValue: null,
				isfavored: false,
				deId: null,
				tanchuang: false,
				maxLength: 0,
				userInfo: null,
				commentList: [],
				nowCurrentPage: 0,
				size: 10,
				dataList: [],
				id: 0,
				zang: false,
				bottomModal: true,
				pinglun: false,
				tanchuang: false,
				myComment: true,
				noteContent: `我有一个小秘密，夜深人静时，在皎洁的月光下，我翻阅心灵日记，涌上心头的是涩涩的酸楚。这件事发生在几个月前，我参加了淮安市电视台举办的"小荷风采"才艺大赛，得到了二等奖以及二百元奖金，并在颁奖晚会上参加演出，节目在电视上转播。小朋友们都称我为"小歌星"，可谁知道我心中的难受呢?我一直有一个愿望，能成为一个全世界鼎鼎有名的歌唱家，可这只是个空想，因为我从来没有积极地练过唱歌。每次钢琴课结束时老师都会带我们练一会儿声，唱一会儿歌，老师要我们经常练声练气息，可是不知怎么我却不喜欢练声，也从来没有练过气息。老师说，我只能凭着现在的嗓音唱歌，长大了如果想当歌唱家，是远远不够的。我听了只是伤心，我也知道想当个合格的歌唱家练声练气息是必不可少的，可是回家却仍然不练。"难道这个梦要破碎?"我摇摇头,"不会吧?"这个小秘密一直珍藏在我心里，它启发我，成名成家并不容易，主要是坚持苦练，才能圆了心中的明星梦。`,
				isCard: true,
				isLoad: true,
				isChudi: false
			};
		},
		onLoad: function(options) {
			console.log("文章信息：")
			console.log(options.id)
			this.id = options.id
			// this.id = 5
			// setTimeout(function() {
			// 	console.log('start pulldown');
			// }, 1000);
			// uni.startPullDownRefresh();
		},
		onPullDownRefresh() {
			console.log("下拉刷新")
			this.initComment()
			this.getMyDetail()
			this.getUserInfo()
			// uni.showToast({
			// 	title: "获取成功！",
			// 	icon: 'none',
			// 	duration: 1500
			// })
			// setTimeout(function() {
			// 	uni.stopPullDownRefresh();
			// }, 1000);
		},
		onReachBottom() {
			console.log("上拉触底")
			if (this.commentList.length < 10) {
				this.isChudi = true
				return;
			}
			if (this.commentList.length >= this.maxLength) {
				this.isChudi = true
				uni.showToast({
					title: "已经到底了！",
					icon: 'none',
					duration: 1500
				})
				return;
			}
			++this.nowCurrentPage;
			console.log("上拉触底中nowCurrentPage：")
			console.log(this.nowCurrentPage)
			this.getMyComment(this.nowCurrentPage)
			// uni.showToast({
			// 	title: "已经到底了！",
			// 	icon: 'none',
			// 	duration: 1500
			// })
		},
		mounted() {
			if (this.id == null) {
				return;
			}
			this.nowCurrentPage = 1
			this.getMyDetail()
			this.getMyComment(this.nowCurrentPage)
			this.getUserInfo()
			this.isfavoredComment()
		},
		methods: {
			//将url改变成背景图片
			changeAvatar(url){
				if(url == null || url == ""){
					return "background-image:url(static/tabbar/about.png);"
				}
				return "background-image:url("+url+");"
			},
			//输入

			//发布评论
			publishComment() {
				console.log("发布评论")
				if (this.inputValue == null || this.inputValue.replace(/\s+/g, '') == '') {
					console.log("输入不能为空");
					uni.showToast({
						title: "输入不能为空！",
						icon: 'none',
						duration: 1500
					})
					return;
				}
				//限制条数
				if (this.limitComment == 0) {
					uni.showToast({
						title: "操作过快，喝口水后再来评论吧！",
						icon: 'none',
						duration: 1500
					})
					return;
				}

				console.log("执行输入评论！")
				this.request({
					url: "/comment/add",
					method: "POST",
					data: {
						id: this.id,
						content: this.inputValue
					}
				}).then(resp => {
					if (resp.code == 200) {
						uni.showToast({
							title: "评论成功！",
							icon: 'none',
							duration: 1500
						})
						this.inputValue = null
						this.initComment()
						return;
					}
					uni.showToast({
						title: "评论失败！",
						icon: 'none',
						duration: 1500
					})
				})
				// console.log(this.inputValue.length)
				// console.log(this.inputValue)
			},
			//查看是否点过赞了
			isfavoredComment() {
				this.request({
					url: "/comment/isFavored",
					method: "POST",
					data: {
						id: this.id
					}
				}).then(resp => {
					console.log("是否点过赞了")
					console.log(resp)
					if (resp.code == 200) {
						if (resp.data) {
							this.isfavored = true
							return;
						}
						this.isfavored = false
					}

				})
			},
			//关闭窗口
			closeTanchuang() {
				this.tanchuang = false
			},
			//初始化数据
			initComment() {
				this.nowCurrentPage = 1
				this.request({
					url: "/communication/commentOne",
					method: "POST",
					data: {
						currentPage: 1,
						size: this.size,
						id: this.id
					}
				}).then(resp => {
					if (resp.code == 200) {
						this.maxLength = resp.data.total
						this.commentList = resp.data.data
						setTimeout(function() {
							uni.stopPullDownRefresh();
						}, 1000);
					}
				})
			},
			//删除评论窗口
			trueTanchuang() {

				this.request({
					url: "/comment/deleteOne",
					method: "POST",
					data: {
						id: this.deId
					}
				}).then(resp => {
					if (resp.code == 200) {
						this.initComment()
						uni.showToast({
							title: "删除成功！",
							icon: 'none',
							duration: 1500
						})
						this.tanchuang = false
						return;
					}
					this.tanchuang = false
					uni.showToast({
						title: "删除失败，请反馈情况给管理员！",
						icon: 'none',
						duration: 1500
					})
				})
			},
			//删除评论
			deleteComment(id) {
				console.log("删除:" + id)
				this.deId = id
				this.tanchuang = true
			},
			//获取用户信息
			getUserInfo() {
				this.request({
					url: "/user/info",
					method: "POST"
				}).then(resp => {
					if (resp.code == 200) {
						this.userInfo = resp.data
					}
				})
			},
			//获取评论内容
			getMyComment(currentPage) {
				if (this.id == null) {
					console.log("id为空！")
					return;
				}
				this.request({
					url: "/communication/commentOne",
					method: "POST",
					data: {
						currentPage: currentPage,
						id: this.id,
						size: this.size
					}
				}).then(resp => {
					if (resp.code == 200) {
						console.log("获取评论内容成功！")
						this.maxLength = resp.data.total
						this.commentList = this.commentList.concat(resp.data.data)
					}
				})
			},
			getMyDetail() {
				if (this.id == null) {
					console.log("id为空！")
					return;
				}
				this.request({
					url: "/communication/one",
					method: "POST",
					data: {
						id: this.id
					}
				}).then(resp => {
					if (resp.code == 200) {
						console.log("获取该圈子信息：")
						this.dataList = resp.data[0]
						console.log(this.dataList)
					}

				})
			},
			dianzang() {
				if (this.isfavored) {
					console.log("执行取消点赞")
					this.request({
						url: "/comment/cancel",
						method: "POST",
						data: {
							id: this.id
						}
					}).then(resp => {
						if (resp.code == 200) {
							console.log("取消点赞成功！")
							this.isfavored = false
							this.getMyDetail()
							return;
						}
						uni.showToast({
							title: "取消点赞失败！",
							icon: 'none',
							duration: 1500
						})
					})
					return;
				}
				console.log("执行点赞：")
				this.request({
					url: "/comment/favor",
					method: "POST",
					data: {
						id: this.id
					}
				}).then(resp => {
					if (resp.code == 200) {
						console.log("点赞成功！")
						this.isfavored = true
						this.getMyDetail()
						return;
					}
					console.log("执行点赞失败！")
					uni.showToast({
						title: "点赞失败！",
						icon: 'none',
						duration: 1500
					})
				})

			},
			shareP() {
				uni.showToast({
					title: "该功能暂时未开放！",
					icon: 'none',
					duration: 1500
				})
			},
			closePinglun() {
				this.pinglun = false
			},
			isPinglun() {
				console.log(this.pinglun)
				if(!this.userInfo.communicationEnabled){
					uni.showToast({
						title: "你已经被禁止发布，请联系管理员！",
						icon:'none',
						duration: 1500
					})
					return;
				}
				console.log("开启评论")
				
				this.pinglun = true
				console.log(this.pinglun)
			},
			myWrite() {
				console.log("发布")
				uni.navigateTo({
					url: '/pages/luntan/addNote'
				})
			},
			IsCard(e) {
				this.isCard = e.detail.value
			},
		}
	}
</script>

<style>

</style>