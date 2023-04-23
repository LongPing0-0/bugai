<template>
	<view class="content" :style="{height:screenHeight+'px'}">
		<view class="mod1">
			<!-- 实验介绍 -->
			<view >
				假设我们有一袋小球，每个小球的花纹都不相同。
				如果我们无放回地从袋子里抽取小球，一共有多少种可能出现的花纹排列呢？
			</view>
		</view>
		<view class="mod2">
				<!-- 排列组合动画 -->
					<pailiezuhe></pailiezuhe>
		</view>
		<view class="mod3">
			<!-- 实验小结 -->
		</view>
	</view>
</template>

<script>
	import pailiezuhe from '@/components/pailiezuhe/pailiezuhe.vue'
	export default{
		data(){
			return{
				
			}
		},
		components:{
			pailiezuhe
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
		margin: 3px;
		width: 90%;
		background-color: #ffffff;
		/* justify-content: center; */
		text-align: 18px;
		border-radius: 5px;
	}
	.mod2 {
		margin: 3px;
		width: 90%;
		background-color: #ffffff;
		border-radius: 5px;
	}
	.mod3 {
		margin: 3px;
		width: 90%;
		/* height: 200px; */
		background-color: #ffffff;
		justify-content: center;
		border-radius: 8px;
	}
	/* 点击更多的样式 */
	.show-more{
		width:100%;
		height:2px;
		background-color: #4CD964;
		transition:height 1s;
		-moz-transition:height 1s; /* Firefox 4 */
		-webkit-transition:height 1s; /* Safari and Chrome */
		-o-transition:height 1s; /* Opera */
	}
	.show-more-click{
		height:300px;
	}
</style>