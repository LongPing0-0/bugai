<template>
	<view>
		<view>
			<u-collapse @change="change" @close="close" @open="open">
				<u-collapse-item :title="item.title" v-for="item in helpList" style="margin: 15px;">
					<text class="u-collapse-content">{{item.content}}</text>
					<button  @click="shangchu(item.id)" class="cuIcon-delete bg-gray"></button>
				</u-collapse-item>
			</u-collapse>
		</view>
		
		<!-- 悬浮添加按钮 -->
		<view class="add-float" @click="addDocument()"><view class="cuIcon-roundaddfill iconSize"></view></view>
		
		<!-- 删除框 -->
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
		<!-- 模态窗 -->
		<view class="cu-modal" :class="!!modalName ? 'show' : ''">
			<view class="cu-dialog">
				<view class="cu-bar bg-white justify-end">
					<view class="content">帮助文档</view>
					<view class="action"><text class="cuIcon-close text-red"></text></view>
				</view>
				<form>
					<view class="text-left">
						<view class="cu-form-group margin-top">
							<view class="title">标题：</view>
							<input placeholder="请输入帮助文档标题"  v-model="submitData.title"/>
						</view>
						<view class="cu-form-group">
							<view class="title">内容：</view>
							<textarea placeholder="请输入帮助文档内容" v-model="submitData.content"></textarea>
						</view>
					</view>
					<view class="cu-bar bg-white justify-end">
						<view class="action">
							<button class="cu-btn line-green text-green" @tap="hideModal">取消</button>
							<button class="cu-btn bg-green margin-left" @tap="submitHelpDocument">确定</button>
						</view>
					</view>
				</form>
			</view>
		</view>
	</view>

</template>

<script>
	export default {
		data(){
			return{
				id: null,
				tanchuang: false,
				userInfo: null,
				submitData:{
					title: "",
					content: ""
				},
				modalName: false,
				helpList: [{
					title: "文档指南",
					content: "涵盖uniapp各个方面，给开发者方向指导和设计理念，让您茅塞顿开，一马平川"
				},{
					title: "文档指南",
					content: "涵盖uniapp各个方面，给开发者方向指导和设计理念，让您茅塞顿开，一马平川"
				},{
					title: "文档指南",
					content: "涵盖uniapp各个方面，给开发者方向指导和设计理念，让您茅塞顿开，一马平川"
				},{
					title: "文档指南",
					content: "涵盖uniapp各个方面，给开发者方向指导和设计理念，让您茅塞顿开，一马平川"
				}]
			}
		},
		methods: {
			closeTanchuang(){
				this.tanchuang = false
			},
			trueTanchuang(){
				console.log(this.id)
				this.request({
					url: "/help/remove",
					method: "POST",
					data: {
						id: this.id
					}
				}).then(resp=>{
					if(resp.code == 200){
						uni.showToast({
							title: "删除该帮助文档成功！",
							icon:'none',
							duration: 1500
						})
						this.getAllHelpDocument()
						this.tanchuang = false
						return;
					}
				})
				uni.showToast({
					title: "删除帮助文档失败！",
					icon: 'none',
					duration: 1500
				})
				this.tanchuang = false
			},
			shangchu(id){
				console.log(id)
				this.id = id
				if(this.userInfo.rid != 4){
					uni.showToast({
						title: "权限不足！",
						icon: "none",
						duration: 1500
					})
					return;
				}
				this.tanchuang = true
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
			addDocument(){
				this.submitData.title = ""
				this.submitData.content = ""
				if(this.userInfo.rid != 4){
					uni.showToast({
						title: "权限不足！",
						icon: 'none',
						duration: 1500
					})
					return;
				}
				this.modalName = true
			},
			submitHelpDocument(){
				if(this.submitData.title == null || this.submitData.data == "" ||this.submitData.content == null || this.submitData.content == "" ){
					uni.showToast({
						title: "输入错误！",
						icon: 'none',
						duration: 1500
					})
					return;
				}
				console.log("提交更新文档内容")
				console.log(this.submitData.title)
				console.log(this.submitData.content)
				this.request({
					url: "/help/add",
					method: "POST",
					data: this.submitData
				}).then(resp=>{
					if(resp.code == 200){
						uni.showToast({
							title: "新增帮助文档成功！",
							icon: 'none',
							duration: 1500
						})
						this.getAllHelpDocument()
						this.modalName = false
						return;
					}
				})
				
				uni.showToast({
					title: "新增帮助文档失败！",
					icon:'none',
					duration: 1500
				})
				this.modalName = false
			},
			hideModal(){
				this.modalName = false
			},
			open(e) {
				// console.log('open', e)
			},
			close(e) {
				// console.log('close', e)
			},
			change(e) {
				// console.log('change', e)
			},
			//获取所有帮助文档
			getAllHelpDocument(){
				var that = this
				this.request({
					url: "/help/enabled",
					method: "GET"
				}).then(resp=>{
					console.log(resp)
					if(resp.code == 200){
						that.helpList = resp.data
					}
				})
			}
		},
		mounted() {
			this.getAllHelpDocument()
			this.getUserInfo()
		}
	}
</script>
<style lang="scss">
.enl-log-box {
	margin: 30rpx;
	padding: 20rpx;
	background: #ffffff;
	box-shadow: 0px 4rpx 20rpx rgba(137, 143, 155, 0.2);
	border-radius: 16rpx;
	line-height: 40rpx;

	.title {
		font-size: 34rpx;
		font-weight: 400;
		color: #333333;
	}
	.date {
		font-size: 24rpx;
		font-weight: 400;
		color: #999999;
	}
	.manages {
		margin: 10rpx 0 0;
		padding: 20rpx;
		background: #f1f1f1;
		border-radius: 14rpx;
		font-size: 24rpx;
		font-weight: 400;
		color: #666666;
	}
}
.add-float {
	position: fixed;
	bottom: 30rpx;
	right: 30rpx;
	z-index: 99;
	.iconSize {
		font-size: 60rpx;
	}
}
</style>