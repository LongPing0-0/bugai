<template>
	<view>
		<view class="cu-timeline">
			<view class="cu-time">昨天</view>
			<view class="cu-item cur cuIcon-noticefill">
				<view :class="getRandomColor(Math.floor(Math.random() * 12))">
					<text>10:00</text>
					<rich-text :nodes="strings"></rich-text>
					 新增帮助文档，更新日志
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				color: ['content bg-red shadow-blur','content bg-orange shadow-blur','content bg-yellow shadow-blur',
				'content bg-olive shadow-blur','content bg-blue shadow-blur','content bg-pink shadow-blur',
				'content bg-green shadow-blur','content bg-purple shadow-blur','content bg-brown shadow-blur',
				'content bg-cyan shadow-blur','content bg-mauve shadow-blur','content bg-grey shadow-blur'],
				strings: '<div style="text-align:center;"><img src="https://web-assets.dcloud.net.cn/unidoc/zh/uni@2x.png"/></div>'
			};
		},
		// created() {
		// 	this.getRandomColor(Math.floor(Math.random() * 12))
		// },
		methods:{
			//获取随机背景颜色
			getRandomColor(index){
				console.log(index)
				// console.log("随机获取颜色")
				console.log(this.color[index])
				return this.color[index];
			}
		}
	}
</script>

<style>

</style>
