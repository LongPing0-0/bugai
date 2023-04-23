<template>
	<view class="content" :style="{height:screenHeight+'px'}">
		<view class="mod1">
			<!-- 实验介绍 -->
			<view style="font-size: 15pt;">通过模拟的计算器, 进行运算得出集合的结果。</view>
			<view style="font-size: 15pt;">可实现的结果有</view>
			<view style="font-size: 15pt;">A，B，C，A̅，B̅，C̅，Ω，ϕ，A⋂B，A⋂C，C⋂B，A⋃B，A⋃C，C⋃B，A̅⋂B̅，A̅⋂C̅，B̅⋂C̅，A̅⋃B̅⋃C̅，A̅⋃B̅，A̅⋃C̅，B̅⋃C̅，A⋂B⋂C，A⋃B⋃C，A̅⋂B̅⋂C̅，A⋂B⋃C，A⋂C⋃B，B⋂C⋃A。</view>
		</view>
		<view class="mod2">
			<!-- 实验部分 -->
			<div></div>
				<!-- 集合论计算器 -->
				<vennJiSuanQi></vennJiSuanQi>
		</view>
		<view class="mod3">
			<!-- 实验小结 -->
			<view></view>
			<view style="float: left;font-size: 13pt;">集合是指具有某种特定性质的、具体的或抽象的对象汇总而成的集体。韦恩图是解决集合运算的利器。</view>
		</view>
	</view>
</template>

<script>
	import vennJiSuanQi from '@/components/vennJiSuanQi/vennJiSuanQi.vue'
	export default{
		data(){
			return{
				
			}
		},
		components:{
			vennJiSuanQi
		},
		methods:{}
	}
</script>

<style>
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		background-color: #609df8;
		color: #609df8;
	}
	.mod1 {
		margin-top: 3%;
		float: left;
		padding: 2%;
		width: 48vh;
		background-color: #ffffff;
		border-radius: 5px;
	}
	.mod2 {
		margin: 3px;
		width: 90%;
		background-color: #ffffff;
		border-radius: 5px;
	}
	.mod3 {
		margin: 3px;padding: 5px;
		width: 48vh;
		background-color: #ffffff;
		font-size: 16px;
		font-weight: 500;
		color: black;
		border-radius: 5px;
	}
</style>