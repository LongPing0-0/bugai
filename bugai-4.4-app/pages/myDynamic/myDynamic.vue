<template>
	<view>
		<view class="cu-bar bg-white solid-bottom">
			<view class="action">
				<text class="cuIcon-titles text-orange"></text> 样式切换
			</view>
			<view class="action">
				<switch :class="isCard?'checked':''" :checked="isCard?true:false" @change="IsCard"></switch>
			</view>
		</view>


		<view  v-for="item in dataList"  class="cu-card dynamic" :class="isCard?'no-card':''" style="margin-bottom: 14px;">
			
			<view class="cu-item shadow">
				<view class="cu-list menu-avatar">
					<view class="cu-item">
						<!-- 头像 -->
						<view @click="goDetail(item.id)" class="cu-avatar round lg"
							:style="changeAvatar(item.avatar)">
						</view>

						<view class="content flex-sub" @click="goDetail(item.id)">
							<!-- 姓名 -->
							<view>{{item.nickname}}</view>
							<!-- 发布时间 -->
							<view class="text-gray text-sm flex justify-between">
								{{item.created}}
							</view>
						</view>
						<view v-if="item.uid == userInfo.uid ?true:false || userInfo.rid == 4"  class="margin-top-sm flex justify-between" @click="shangchu(item.id)">
							<view><button class="cuIcon-delete text-gray"></button></view>
						</view>
					</view>
				</view>



				<view class="text-content" @click="goDetail(item.id)">
					<view class="margin-top-xs" v-html="item.content"></view>
				</view>

				<view class="text-gray  text-right padding" @click="goDetail(item.id)">
					<!-- <text class="cuIcon-attentionfill margin-lr-xs"></text> 10 -->
					<!-- 点赞人数 -->
					<text class="cuIcon-appreciatefill margin-lr-xs">{{item.favorCount}}</text>
					<!-- 评论人数 -->
					<text class="cuIcon-messagefill margin-lr-xs">{{item.commentCount}}</text>
				</view>

			</view>
		</view>



		<!-- star -->
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

		<!--发布攻略按钮-->
<!-- 		<view class="cu-list grid">
			<view class="cu-item mypublish" style="position:fixed;right: 10rpx;bottom: 150rpx;">
				<view class="cuIcon-edit lg text-yellow" style="font-size: 100rpx;" @click="myWrite()"></view>
			</view>
		</view> -->
		<!-- 触底 -->
		<view v-if="isChudi" class="cu-load bg-grey" :class="!isLoad?'loading':'over'"></view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				avatar: "background-image:url(static/tabbar/about.png);",
				deId: null,
				tanchuang: false,
				userInfo: null,
				nowCurrentPage: 0,
				size: 10,
				maxLength: 0,
				dataList: [],
				length: 0,
				noteContent: `<h1>我有一个小秘密，夜深人静时，在皎洁的月光下，我翻阅心灵日记，涌上心头的是涩涩的酸楚。这件事发生在几个月前，我参加了淮安市电视台举办的"小荷风采"才艺大赛，得到了二等奖以及二百元奖金，并在颁奖晚会上参加演出，节目在电视上转播。小朋友们都称我为"小歌星"，可谁知道我心中的难受呢?我一直有一个愿望，能成为一个全世界鼎鼎有名的歌唱家，可这只是个空想，因为我从来没有积极地练过唱歌。每次钢琴课结束时老师都会带我们练一会儿声，唱一会儿歌，老师要我们经常练声练气息，可是不知怎么我却不喜欢练声，也从来没有练过气息。老师说，我只能凭着现在的嗓音唱歌，长大了如果想当歌唱家，是远远不够的。我听了只是伤心，我也知道想当个合格的歌唱家练声练气息是必不可少的，可是回家却仍然不练。"难道这个梦要破碎?"我摇摇头,"不会吧?"这个小秘密一直珍藏在我心里，它启发我，成名成家并不容易，主要是坚持苦练，才能圆了心中的明星梦。</h1>`,
				isCard: true,
				isLoad: true,
				isChudi: false
			};
		},
		onLoad: function(options) {

		},
		onPullDownRefresh() {
			console.log("下拉刷新")
			this.initMydata()

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
			if(this.dataList.length < 10){
				this.isChudi = true
				return;
			}
			if(this.dataList.length >= this.maxLength){
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
			this.getAllCommunications(this.nowCurrentPage)


		},
		mounted() {
			this.getUserInfo()
			this.nowCurrentPage = 1
			this.getAllCommunications(this.nowCurrentPage)
		},
		methods: {
			//将url改变成背景图片
			changeAvatar(url){
				if(url == null || url == ""){
					return "background-image:url(static/tabbar/about.png);"
				}
				return "background-image:url("+url+");"
			},
			closeTanchuang(){
				console.log("关闭弹窗")
				this.deId = null
				this.tanchuang = false
			},
			trueTanchuang(){
				console.log("确认删除！")
				console.log(this.deId)
				this.request({
					url: "/communication/deOne",
					method: "POST",
					data: {
						id: this.deId
					}
				}).then(resp=>{
					if(resp.code == 200){
						this.initMydata()
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
			// 初始化数据
			initMydata(){
				this.nowCurrentPage = 1
				this.request({
					url: "/communication/myself",
					method: "POST",
					data: {
						  currentPage: 1,
						  size: this.size
					}
				}).then(resp=>{
					if(resp.code == 200){
						this.maxLength = resp.data.total
						this.dataList = resp.data.data
						setTimeout(function() {
							uni.stopPullDownRefresh();
						}, 1000);
					}
				})
			},
			getUserInfo(){
				this.request({
					url: "/user/info",
					method: "POST"
				}).then(resp=>{
					if(resp.code == 200){
						this.userInfo = resp.data
					}
				})
			},
			// 删除圈子信息
			shangchu(id){
				console.log("删除:"+id)
				this.deId = id
				this.tanchuang = true
			},
			getAllCommunications(currentPage){
				this.request({
					url: "/communication/myself",
					method: "POST",
					data: {
						  currentPage: currentPage,
						  size: this.size
					}
				}).then(resp=>{
					if(resp.code == 200){
						console.log("获取圈子信息：")
						// console.log(resp.data.data)
						this.maxLength = resp.data.total
						this.dataList = this.dataList.concat(resp.data.data)
					}
				})
			},
			goDetail(param){
				uni.navigateTo({
					url: "/pages/luntan/details?id="+param
				})
			},
			myWrite(){
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