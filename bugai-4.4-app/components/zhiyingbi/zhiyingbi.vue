<template>
	<view>
		<!-- 这是掷硬币动画 -->
		<body>
		  <div id="result" :class="result">{{stateContent}}</div>
		  <div id="icon-box" :class="iconBox">
		    <div class="box">
		      <div class="icon icon-up"></div>
		      <div :class="state"></div>
		    </div>
		  </div>
		  <button id="play" @click="playCoin">掷硬币</button>
		</body>
	</view>
</template>

<script>
		export default {
			name: "zhiyingbi",
			data(){
				return{
					state: "icon icon-back back", //默认正面
					stateContent: "", //输出内容
					result: "result", //控制结束是否出现
					iconBox: "icon-box" //控制动画
				}
			},
			methods:{
				playCoin(){
					this.result = "result";
					this.iconBox = "icon-box toss";
					var that = this;
					
					var innerAudioContext = uni.createInnerAudioContext();
							innerAudioContext.src = '/static/coin/icon.mp3';
							innerAudioContext.play(); //播放音频
							
					setTimeout(function(){
						var random = Math.floor(Math.random() * 2);
						if (!random) {
							//反
								that.state = "icon icon-back" //点击设置反面
								that.stateContent = "反"
								that.result = "result show"
								that.iconBox = "icon-box"
						} else {
							//正
								that.state = "icon icon-back back" //点击设置正面
								that.stateContent = "正"
								that.result = "result show"
								that.iconBox = "icon-box"
						}
					},2000)
				}
			}
		}
</script>

<style>
	* {
	  margin: 0;
	}
	
	body {
	  display: flex;
	  flex-direction: column;
	  justify-content: center;
	  align-items: center;
	  background-image: linear-gradient(to top, #dfe9f3 0%, white 100%);
	}
	.icon-box {
	  width: 100px;
	  height: 100px;
	  position: relative;
	}
	
	.box {
	  height: 100%;
	  position: relative;
	  transform-style: preserve-3d;
	}
	
	.icon {
	  width: 100%;
	  height: 100%;
	  left: 0;
	  top: 0;
	  position: absolute;
	  background-position: center;
	  background-repeat: no-repeat;
	  background-size: 100% auto;
	  backface-visibility: hidden;
	}
	
	.icon-up {
	  background-image: url('/static/coin/img/icon-up.png');
	}
	
	.icon-back {
	  background-image: url('/static/coin/img/icon-back.png');
	}
	.icon-back.back {
	  transform: rotateX(180deg);
	}
	
	.icon-box.toss {
	  animation: up-down 1.5s ease-in-out both;
	}
	.icon-box.toss .box {
	  animation: toss 0.6s linear infinite;
	}
	
	
	@keyframes up-down {
	  from {
	    transform: translateY(0);
	  }
	  40%,
	  70%
	   {
	    transform: translateY(-240px);
	  }
	  to {
	    transform: translateY(0);
	  }
	}
	
	@keyframes toss {
	  from {
	    transform: rotateX(0deg);
	  }
	
	  to {
	    transform: rotateX(1080deg);
	  }
	}
	
	button {
	  margin: 8px;
	  width: 160px;
	  height: 45px;
	  border: 0;
	  color: #fff;
	  border-radius: 4px;
	  font-size: 18px;
	  background-color: #aaaaff; /* 掷硬币方框颜色 */
	  cursor: pointer;
	  box-shadow: 0 5px 0 0 #55aaff; /* 掷硬币方框颜色 */
	  transition: all 0.15s linear;
	}
	
	button:active {
	  transform: translateY(5px);
	  box-shadow: 0 3px 0 0 #d35400;
	}
	
	.result {
	  width: 60px;
	  height: 60px;
	  border-radius: 12px;
	  background-color: #55aa7f;
	  margin-bottom: 100px;
	  color: #fff;
	  font-size: 16px;
	  font-weight: bold;
	  display: inline-flex;
	  justify-content: center;
	  align-items: center;
	  opacity: 0;
	  transform: scale(0.1);
	  transition: all 0.2s ease-in-out;
	}
	
	.result.show {
	  opacity: 1;
	  transform: scale(1);
	}
</style>