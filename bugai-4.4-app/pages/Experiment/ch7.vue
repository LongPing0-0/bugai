<template>
	<view class="content" :style="{height:screenHeight+'px'}">
		<view class="mod1">
			<!-- 实验介绍 -->
			<view>二项分布与泊松分布的近似关系
			<br>
			n=25,p=0.01，泊松分布的参数=np，将二项分布和泊松分布绘制在一个图标中
				要求：
				先自定义n与p
				点击开始实验
				显示二项分布于泊松分布的图像，两者在一个图像中（张卜中，参数给定后再给出图像，可以不做那种随着拉动而变化的）
				当np<10时，两者相似
				共性：
				点击显示相应的概念（建议成记忆词条可折叠那种）
				点击显示相应的公式（建议成记忆词条可折叠那种）
			</view>
		</view>
		<view class="mod2">
			<!-- 实验部分 -->
			<image src="../../static/bar-simple.png" mode=""></image>
			<view style="display: inline-block;">请输入A发生的概率:</view>
			<input class="in1" type="number" placeholder="请输入p" />
			<view style="display: inline-block;">请输入事件总数:</view>
			<input class="in1" type="number" placeholder="请输入n" />

			<botton class="bt1">绘制分布律</botton>
			<table class="tb01" style="border: 2px #302cda solid">
				<tbody>
					<tr>
						<td style="border: 2px #302cda solid">X</td>
						<td style="border: 2px #302cda solid">Cell 2x1</td>
						<td style="border: 2px #302cda solid">Cell 3x1</td>
					</tr>
					<tr>
						<td style="border: 2px #302cda solid">Pk</td>
						<td style="border: 2px #302cda solid">Cell 2x2</td>
						<td style="border: 2px #302cda solid">Cell 3x2</td>
					</tr>
				</tbody>
			</table>

		</view>
		<view class="mod3">这里是实验小结
			<!-- 实验小结 -->
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {

			}
		},
		components: {

		},
		methods: {}
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
		/* height: 320px; */
		background-color: #ffffff;
		justify-content: center;
		border-radius: 5px;
	}

	.mod2 {
		margin: 3px;
		width: 90%;
		/* height: 320px; */
		background-color: #ffffff;
		padding-top: 10px;
		/* justify-content: center; */
		border-radius: 5px;
	}

	.mod3 {
		margin: 3px;
		width: 90%;
		height: 200px;
		background-color: #ffffff;
		justify-content: center;
		border-radius: 8px;
	}

	.in1 {
		display: inline-block;
		margin-top: 10px;
		margin-left: 8px;
		border: 1px solid;
	}

	.tb01 {
		text-align: center;
		margin: 0px auto;
	}

	.bt1 {
		margin: 5px auto;
		text-align: center;
		padding: 5px;
		display: flex;
		background-color: #2979ff;
		color: #ffffff;
		weight: 50%;
		width: 100px;
		font-size: 18px;
		font-weight: 600;
		border-radius: 5px;
	}
</style>
