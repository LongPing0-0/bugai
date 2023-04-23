<template>
	<view class="content" :style="{height:screenHeight+'px'}">
		<view class="mod1">
			<!-- 实验介绍 -->

事件A在每次试验中发生的概率为p，记n次试验中事件A发生的次数为X，画出X的概率分布图。
		</view>
		<view class="mod2">
			<!-- 实验部分 龙平放 -->
			<zhengtaifenbu></zhengtaifenbu>
			
		</view>
		<view class="mod3">
			<!-- 实验小结 -->
在概率论和统计学中，二项分布是n个独立的成功/失败试验中成功的次数的离散概率分布，其中每次试验的成功概率为p。这样的单次成功/失败试验又称为伯努利试验。实际上，当n=1时，二项分布就是伯努利分布。 
一般地，如果随机变量服从参数为和的二项分布，我们记为或。n次试验中正好得到k次成功的概率由概率质量函数给出：
			<image src="/static/3.png" style="width: 100%; height: 55px;"></image>
			<view>
				则这个随机变量就称为正态随机变量，正态随机变量服从的分布就称为正态分布，记作X~N(μ, σ^2)，读作X服从N(μ, σ^2)，或X服从正态分布。
			</view>
			<h3 style="margin-top: 5px;">
				图形特征：
			</h3>
			<view>
				集中性：正态曲线的高峰位于正中央，即均数所在的位置。
			</view>
			<view>
				对称性：正态曲线以均数为中心，左右对称，曲线两端永远不与横轴相交。
			</view>
			<view>
				均匀变动性：正态曲线由均数所在处开始，分别向左右两侧逐渐均匀下降。
			</view>
		</view>

	</view>
</template>

<script>
	import zhengtaifenbu from "@/components/zhengtaifenbu/zhengtaifenbu.vue"
	export default {
		data() {
			return {
				n: "",
				m: "",
				showImg1: false,
				showImg2: false
			}
		},
		components(){
			zhengtaifenbu
		},
		methods: {
			exp() {
				this.showImg1 = false
				this.showImg2 = false
				if (this.n == 0 && this.m == 1) {
					this.showImg1 = true
				}

				if (this.n == 0 && this.m == 1.5) {
					this.showImg2 = true
				}
			}
		}
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
		padding: 5px;
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
		margin: 3px;
		padding: 5px;
		width: 90%;
		background-color: #ffffff;
		font-size: 16px;
		font-weight: 500;
		/* color: black; */
		justify-content: center;
		border-radius: 8px;
	}

	.text {
		/* text-align: center; */
		/** 水平居中 **/
		font-weight: 600;
	}

	.tu {
		text-align: center;
		/** 水平居中 **/

	}
</style>