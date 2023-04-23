<template>
	<view>
		<view class="bg"></view>
		<view class="content">
			<!-- 输入 -->
			<view class="input">
				{{input}}
			</view>
			
			
			<!-- 输入k -->
			<view class="key">
				<view class="call flexs">
					<view class="c-who">{{!call?'❤️我称呼对方🎄':'🎄对方称呼我❤️'}}</view>
					<view class="flexe c-name">
						<view class="flex" v-for="(d,i) in name" :key="i">
							<text v-if="i >= 1">、</text>
							<text>{{d}}</text>
						</view> 
					</view>
				</view>
				<view class="k-wrap">
					<!-- k1 -->
					<view class="flexs">
						<view class="k-i" :class="{'k-h':!input && sex == 1}" @click="callName('老公')">夫</view>
						<view class="k-i" :class="{'k-h':!input && sex == 0}" @click="callName('老婆')">妻</view>
						<view class="k-i" @click="callName('del')">DEL</view>
						<view class="k-i k-bg" @click="callName('ac')">AC</view>
					</view>
					<!-- k2 -->
					<view class="flexs">
						<view class="k-i" @click="callName('爸爸')">父</view>
						<view class="k-i" @click="callName('妈妈')">母</view>
						<view class="k-i" @click="callName('哥哥')">兄</view>
						<view class="k-i" @click="callName('弟弟')">弟</view>
					</view>
					<!-- k1 -->
					<view class="flexs">
						<view class="k-i" @click="callName('姐姐')">姐</view>
						<view class="k-i" @click="callName('妹妹')">妹</view>
						<view class="k-i" @click="callName('儿子')">子</view>
						<view class="k-i" @click="callName('女儿')">女</view>
					</view>
					<!-- k1 -->
					<view class="flexs">
						<view class="k-i k-i2" @click="sheet('sex')">性别:{{sex ==1 ?'男':'女'}}</view>
						<view class="k-i k-i2" @click="sheet('call')">{{!call?'我称呼对方':'对方称呼我'}}</view> 
						<view class="k-i k-bg" @click="equal">=</view>
					</view>
				</view> 
			</view>
		</view>
		
	 
	</view>
</template>

<script>
	
	
	export default {
		data(){
			return{
				 input:'',
				 name:'',
				 
				 sex:1,//1男 0女
				 type:'default',//转换类型：'default'算称谓,'chain'算关系(此时reverse无效)
				 call: false, //称呼方式：true对方称呼我,false我称呼对方
			}
		},
		methods:{
			equal(){
				uni.vibrateShort()
				if(!this.name || !this.name.length){
					uni.showToast({
						title:'😂我也不知道',
						icon:'none'
					})
					 return
				}
				
				let v = this.name.join('、')
				let m = this.call ?'对方称呼我: ':'我称呼对方: '
				
				
				let options = {text:this.input,sex:this.sex,reverse:this.call,type:'chain'};
				let result = relationship(options);
				let cv = result.join('、')
				if(cv){
					cv = '我们的关系: '+cv
				}
				console.log(result);
				
				uni.showModal({
					title:m+v,
					content:cv
				})
			},
			sheet(t){
				let that = this
				this.name = ''
				this.input = ''
				if(t == 'call'){
					uni.showActionSheet({
						itemList:['对方称呼我','我称呼对方'],
						success(e) {
							if(e.tapIndex == 0) that.call = true
							if(e.tapIndex == 1) that.call = false
						}
					})
				}
				if(t == 'sex'){
					uni.showActionSheet({
						itemList:['男','女'],
						success(e) {
							if(e.tapIndex == 0) that.sex = 1
							if(e.tapIndex == 1) that.sex = 0
						}
					})
				}
			},
			callName(name){
				uni.vibrateShort()
				
				if(name == 'ac'){
					this.name = ''
					this.input = ''
					return
				}
				if(name == 'del'){
					if(!this.input) return
					if(this.input.indexOf('的') === -1){
						this.input = ''
						this.name = ''
						return
					}
					this.input = this.input.substr(0,this.input.lastIndexOf('的'))
					let options = {text:this.input,sex:this.sex,reverse:this.call};
					let result = relationship(options);
					console.log('result:',result);
					this.name = result
					return
				}
				if(!this.input){
					 this.input = name
				}else{
					this.input = this.input+'的'+name
				} 
				console.log(this.input);
				
				let options = {text:this.input,sex:this.sex,reverse:this.call};
				let result = relationship(options);
				console.log('result:',result);
				this.name = result
			},
 
		},
		onLoad(e){
			// var options = {text:'儿子的爸爸的妈妈',sex:1};
			// let result = relationship(options);
			// console.log(result);
		},
		onShareAppMessage: function() {
			return {
				title: '亲戚计算器~ 嗯哼', 
				path: '/pages/index/index', 
			};
		},
		onShareTimeline: function() {
			return {
				title: '亲戚计算器~ 嗯哼', 
				path: '/pages/index/index', 
			};
		}
	 
	}
</script>

<style scoped>
	.flex{
		display: flex;
		align-items: center;
	}
	.flexs{
		display: flex;
		align-items: center;
		justify-content: space-between;
	}
	.flexc{
		display: flex;
		align-items: center;
		justify-content: center;
	}
	.flexe{
		display: flex;
		align-items: center;
		justify-content: flex-end;
	}
	.c-name{
		font-size: 46rpx; 
		margin-right: 20rpx;
		flex-wrap: wrap;
		width: 400rpx;
	}
	.c-who{
		color: #dbdbdb; 
	}
	.call{
		font-weight: bold;
		width: 90%;
		margin: auto; 
		padding: 30rpx 0;
	}
	.input{
		color: #c1c1c1;
		line-height: 2;
		padding: 50rpx;
		width: 75%;
		margin:  auto;
		max-height:200rpx;
		overflow-y: scroll;
		background-color: #2c2c2c;
		border-radius: 50rpx;
	}
	.call{
		color: #FFFFFF;
	}
	
	.k-i{
		width: 150rpx;
		height: 150rpx;
		margin: 10rpx 0;
		background-color: rgba(255,255,255,.15);
		border-radius: 50%;
		display: flex;
		align-items: center;
		justify-content: center;
		color: #FFFFFF;
		font-size: 32rpx;
		font-weight: bold;
		transition: all .25s;
		
		background: linear-gradient(145deg, #1e1e1e, #232323);;
		box-shadow:  20rpx 20rpx 40rpx #121212,
		             20rpx 20rpx 40rpx #222222;
	}
	.k-i:active{
		opacity: .5;
		transform: scale(.95);
	}
	.k-i2{
		width: 230rpx;
		border-radius: 120rpx;
	}
	.k-bg{ 
		font-weight: bold;
		font-size: 32rpx;
		box-shadow:none;
		background: #ff9613;
	}
	.k-wrap{
		padding: 30rpx;
	}
	.key{ 
		position: fixed;
		bottom: 0;
		z-index: 6;
		width: 100%; 
		padding-bottom: constant(safe-area-inset-bottom);
		padding-bottom: env(safe-area-inset-bottom);
	}
	.content{
		position: relative;
		z-index: 2;
		padding: 30rpx 0;
	}
	 .bg{
		position: fixed;
		width: 100%;
		height: 100%;
		left: 0;
		top: 0;
		background-color: #1a1a1a; 
	 }
	 .k-h{
		 opacity: 0;
		 /* display: none; */
		 visibility: hidden;
	 }
	  
</style>
