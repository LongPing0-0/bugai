<template>
	<view>
		<shaizishiyan></shaizishiyan>
	</view>
</template>

<script>
	import shaizishiyan from "@/components/shaizishiyan/shaizishiyan.vue"
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			
		},
		components(){
			shaizishiyan
		}
	}
</script>

<style src="@/hybrid/html/shaizi/one.css" scoped>
	
</style>
<template>
	<view class="content" :style="{height:screenHeight+'px'}">
		<view class="mod1">
			<view>这里是实验介绍</view>
		</view>
		<view class="mod2">
				<button style="margin-top: 50px;" @click="shaizishiyan()">进入实验</button>
		</view>
		<view class="mod3">这里是实验小结
		</view>
	</view>
</template>

<script>
	export default{
		data(){
			return{
				
			}
		},
		components:{
			
		},
		methods:{
			shaizishiyan(){
				uni.navigateTo({
					url: "/pages/HtmlExperiment/HtmlExperiment",
				});
			
			}
		}
	}
</script>

<style>
	.content {
		display: flex;
		flex-direction: column;
		text-align: center;
		align-items: center;
		height: 100vh;
		background-color: #609df8;
		color: #609df8;
	}
	.mod1 {
		margin: 3px;
		width: 90%;
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
		width: 90%;
		background-color: #ffffff;
		justify-content: center;
		border-radius: 8px;
	}
</style>