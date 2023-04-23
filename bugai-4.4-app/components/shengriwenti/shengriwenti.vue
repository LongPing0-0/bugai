<template>
  <view class="container">
<!-- 	  <view>
		  假设每人的生日在一年365天的任意一天是等可能的，即都等于1/365，求n(<=365)个人中至少有m人生日相同的概率p。
	  </view> -->
    <view class="form">
      <view class="form-item">
        <text class="form-label">人数 n：</text>
        <input v-model="n" type="number" placeholder="输入人数">
      </view>
      <view class="form-item">
        <text class="form-label">相同人数 m：</text>
        <input v-model="m" type="number" placeholder="输入相同的生日人数">
      </view>
      <view class="form-item">
        <button class="calc-btn" @click="calculate">计算</button>
      </view>
    </view>
    <view class="result" v-if="showResult">
      <text class="result-label">概率：</text>
      <text class="result-value">{{ probability }}</text>
    </view>
  </view>
</template>

<script>
export default {
	name: 'shengriwenti',
  data() {
    return {
      n: null,
      m: null,
      probability: null,
      showResult: false
    }
  },
  methods: {
    calculate() {
      if (!this.n || !this.m) {
        return;
      }
      const numDays = 365;
      let p = 1;
      for (let i = 1; i <= this.m - 1; i++) {
        p *= (numDays - i) / numDays;
      }
      const pAllDifferent = 1 - p;
      let prob = pAllDifferent;
      for (let i = this.m; i <= this.n; i++) {
        prob = prob * ((numDays - i + 1) / numDays) + (1 - prob) * pAllDifferent;
      }
      this.probability = prob.toFixed(4);
      this.showResult = true;
    }
  }
}
</script>


<style>
  .container {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-top: 50rpx;
  }

  .form {
    display: flex;
    flex-direction: column;
    width: 80%;
    background-color: #fff;
    padding: 20rpx;
    border-radius: 10rpx;
    box-shadow: 0 0 10rpx rgba(0, 0, 0, 0.1);
    margin-bottom: 20rpx;
  }

  .form-item {
    display: flex;
    align-items: center;
    margin-bottom: 20rpx;
  }

  .form-label {
    font-size: 32rpx;
    margin-right: 10rpx;
  }

  input {
    flex: 1;
    height: 60rpx;
    font-size: 32rpx;
    padding: 0 20rpx;
    border: 1rpx solid #ddd;
    border-radius: 5rpx;
  }

  .calc-btn {
    background-color: #007aff;
    color: #fff;
    font-size: 32rpx;
    border-radius: 5rpx;
    padding: 10rpx 20rpx;
    border: none;
  }

  .calc-btn:focus,
  .calc-btn:active {
    outline: none;
  }

  .result {
    display: flex;
    flex-direction: column;
    width: 80%;
    background-color: #fff;
    padding: 20rpx;
    border-radius: 10rpx;
    box-shadow: 0 0 10rpx rgba(0, 0, 0, 0.1);
  }

  .result-label {
    font-size: 32rpx;
    margin-bottom: 10rpx;
  }

  .result-value {
    font-size: 48rpx;
    font-weight: bold;
  }
</style>