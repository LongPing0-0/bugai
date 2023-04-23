<template>
	<view class="content" :style="{height:screenHeight+'px'}">
		<view style="background-color: #609df8;"></view>
		<view class="mod1">
			<!-- 实验介绍 -->
			假设某保险公司有n=10000人参加保险，每人每年付x=12元保险费，
			在一年内一个人死亡的概率p1=0.006，被保险人死亡后其家属可向保险公司领m=1000元。
			试问：保险公司亏本的概率p2？保险公司每年利润大于y=40000元的概率p3？
		</view>
		
		<view class="mod3">
			<!-- 实验小结 -->
<!-- 			<view class="tu">
				<view class="a1">
					<image src="/static/an.png" v-show="showImg1"></image>
				</view>
			</view> -->
			
			
			<div>
			    <label for="p1">请输入死亡概率p1：</label>
			        <input id="p1" v-model="p1" type="number" step="0.001" min="0" max="1" style="padding: 3px; border-radius: 6px; border: 1px solid gray;">
			        <button @click="calculate">开始计算</button>
			        <p v-if="p2 !== null">保险公司亏本的概率为{{ p2 }}</p>
					<p></p>
			        <p v-if="p3 !== null">保险公司每年利润大于40000元的概率为{{ p3 }}</p>
			  </div>
		</view>
		
		<view class="mod2">
			<!-- 实验部分 -->
			<!-- <button type="primary" plain="true" @click="exp()">开始实验</button> -->
			为了计算保险公司的亏损概率和利润概率，我们可以使用二项分布。对于每个被保险人，他在一年内死亡的概率是p1，我们可以把这个事件看做是一个成功的二项试验。因此，每个被保险人死亡的概率为p1，不死亡的概率为1-p1。保险公司亏损的情况发生在死亡的被保险人数量超过了m个，因此我们需要计算死亡人数在m个及以上的概率。利润超过y的情况发生在死亡人数在m个及以下的情况下，收入超过支出的情况，因此我们需要计算死亡人数在m个及以下的概率。
			
			根据二项分布的公式，对于n个试验，每个试验成功的概率为p，试验成功的次数为k的概率为：
			P(k) = C(n, k) * p^k * (1-p)^(n-k)
			其中，C(n, k)表示从n个试验中选取k个试验成功的组合数。
		</view>
	</view>
</template>

<script>
export default {
  data() {
    return {
		screenHeight: uni.getSystemInfoSync().windowHeight,
      p1: 0.01,
      p2: null,
      p3: null,
    };
  },
  methods: {
    calculate() {
      const n = 10000;
      const x = 12;
      const m = 1000;
      const y = 40000;
      
      const E_X = n * this.p1;
      const E_Y = n * this.p1 * m;
      const E_Z = n * this.p1 * m;
      const R = n * x;
      const N = R - E_Z;
      const variance_N = n * Math.pow(x, 2) * this.p1 + n * this.p1 * Math.pow(m, 2);
      const std_N = Math.sqrt(variance_N);
      const z_score = (y - N) / std_N;
      
      // 计算保险公司亏本的概率
      const p2 = this.normalDistribution(N, std_N, 0);

      // 计算保险公司每年利润大于40000元的概率
      const p3 = this.normalDistribution(N, std_N, z_score);

      this.p2 = p2.toFixed(4);
      this.p3 = p3.toFixed(4);
    },
    normalDistribution(x, std, mean) {
      // 标准正态分布的概率密度函数
      const u = Math.abs(x - mean) / std;
      const y = (1 / (Math.sqrt(2 * Math.PI))) * Math.exp(-u * u / 2);
      return y;
    }
  }
};
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
		height: 200px;
		background-color: #ffffff;
		font-size: 16px;
		font-weight: 500;
		color: black;
		justify-content: center;
		border-radius: 8px;
	}

	.text {
		text-align: center;
		/** 水平居中 **/
		font-weight: 600;
	}

	.tu {
		text-align: center;
		/** 水平居中 **/

	}
</style>