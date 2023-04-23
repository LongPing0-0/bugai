<template>
	<view class="content" :style="{height:screenHeight+'px'}">
		<view class="mod1">
			<!-- 实验介绍 -->
			<view>
		     一个随机事件的概率是一个介于0与1之间的实数，这个实数的大小反映了这个事件发生的可能性。因此，概率为0意味着这个事件不可能发生（不可能事件），概率为1意味着这个事件必然发生（必然事件）。
			</view>
		</view>
		<view class="mod2">
				<!-- 掷硬币实验 -->
				<yinbishiyan></yinbishiyan>
		</view>
		<view class="mod3">
			以一个投掷一枚公平的硬币（出现正面和反面的概率相等，均为1/2）的经典的概率实验为例：。在现实中，如果我们重复抛一枚硬币，出现正面的频率可能不会恰好是50%。但是当抛硬币的次数增加时，出现正面的概率会越来越接近50%。
			<!-- 实验小结 -->
		</view>
		<view class="mod2"><!-- 这里放实验展示 -->
			<!-- 实验部分 -->
				<!-- 掷硬币动画 -->
				<zhiyingbi></zhiyingbi>
<!-- 				掷硬币实验
				<yinbishiyan></yinbishiyan> -->
		</view>
	</view>
</template>

<script>
	import zhiyingbi from "@/components/zhiyingbi/zhiyingbi.vue"

	import yinbishiyan from "@/components/yinbishiyan/yinbishiyan.vue"

	export default{
		data(){
			return{
				
			}
		},
		components:{
			zhiyingbi,
			yinbishiyan

		},
		methods:{}
	}
</script>

<style>
	.content {
		display: flex;
		flex-direction: column;
		/* text-align: center; */
		align-items: center;
		background-color: #609df8;
		color: #609df8;
	}
	.mod1 {
		margin: 3px;padding: 5px;
		width: 90%;
		background-color: #ffffff;
		float: left;
		justify-content: left;
		border-radius: 5px;
	}
	.mod2 {
		margin: 3px;
		padding: 3px;
		width: 90%;
		/* height: 320px; */
		background-color: #ffffff;
		justify-content: center;
		border-radius: 5px;
	}
	.mod3 {
		margin: 3px;padding: 5px;
		width: 90%;
		background-color: #ffffff;
		font-size: 16px;
		font-weight: 500;
		color: black;
		justify-content: center;
		border-radius: 8px;
	}
	/* 点击更多的样式 */
/* 	.show-more{
		width:100%;
		height:2px;
		background-color: #4CD964;
		transition:height 1s;
		-moz-transition:height 1s; Firefox 4
		-webkit-transition:height 1s; Safari and Chrome
		-o-transition:height 1s;  Opera
	}
	.show-more-click{
		height:300px;
	} */
</style>