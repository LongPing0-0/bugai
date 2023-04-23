<template>
	<view class="content" :style="{height:screenHeight+'px'}">
		<view class="mod1">
			<!-- 实验介绍 -->
			<view>
			模拟一名运动员进行射击训练，统计每次独立实验的击靶分数，展示数据的离散情况。
			</view>
			<view>
				通过点击开始按钮进行10次模拟射击实验，将数据记录在下方表格中并计算得出期望与方差。
			</view>
		</view>
		<view class="mod2">
			<!-- 实验部分 -->
				<!-- 打靶实验 -->
				<dabatu></dabatu>
		</view>
		<view class="mod3">
			方差是衡量随机变量或一组数据时离散程度的度量，同期望也分为离散型和连续性。
			<!-- 实验小结 -->
		</view>
	</view>
</template>

<script>
	import dabatu from '@/components/dabatu/dabatu.vue'
	export default{
		data(){
			return{
				
			}
		},
		components:{
			dabatu
		},
		methods:{}
	}
</script>

<style>
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		height: 100vh;
		background-color: #609df8;
		color: #609df8;
	}
	.mod1 {
		margin-top: 3%;
		margin-bottom: 3%;
		float: left;
		padding: 2%;
		width: 48vh;
		background-color: #ffffff;
		justify-content: center;
		border-radius: 5px;
	}
	.mod2 {
		margin: 3px;
		width: 90%;
		background-color: #ffffff;
		justify-content: center;
		border-radius: 5px;
	}
	.mod3 {
		margin: 3px;
		padding: 2%;
		width: 48vh;
		background-color: #ffffff;
		font-size: 16px;
		font-weight: 500;
		color: black;
		justify-content: center;
		border-radius: 8px;
	}
</style>