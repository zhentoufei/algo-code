# import sys
#
# sys.setrecursionlimit(1000000)


class Solution(object):
    def coinChange(self, coins, amount):

        # amount_dict = {}
        amount_dict = [float('inf')] * (amount + 1)  # 预先分配好数据内存，节省运行时间和空间
        final_count = self.dp2(coins, amount, amount_dict)

        return final_count

    def dp(self, coins, amount, amount_dict):
        '''
        该方法是
        :param coins:
        :param amount:
        :param amount_dict:
        :return:
        '''
        if amount < 0:
            return -1

        if amount == 0:
            return 0

        if amount in amount_dict.keys():
            return amount_dict[amount]

        final_count = float('inf')
        length = len(coins)
        for i in range(length):
            sub_amount = amount - coins[i]
            tmp_final_count = self.dp(coins, sub_amount, amount_dict)

            if tmp_final_count == -1:
                continue
            else:
                final_count = min(final_count, tmp_final_count + 1)

        if final_count == float('inf'):
            final_count = -1
        amount_dict[amount] = final_count
        return final_count

    def dp2(self, coins, amount, amount_dict):
        #
        # if amount in amount_dict.keys():
        #     return amount_dict[amount]
        if amount_dict[amount] != float('inf'):
            return amount_dict[amount]

        for current_amount in range(amount + 1):

            final_count = float('inf')
            if current_amount == 0:
                final_count = 0
            else:

                for coin in coins:
                    sub_amout = current_amount - coin
                    if sub_amout < 0 or (sub_amout > 0 and amount_dict[sub_amout] == -1):
                        continue

                    final_count = min(final_count, amount_dict[sub_amout] + 1)

                if final_count == float('inf'):
                    final_count = -1

            amount_dict[current_amount] = final_count
        return amount_dict[amount]


if __name__ == '__main__':
    coins = [5000,1]
    amount = 7047
    #
    # coins = [11, 22, 23, 24, 25, 26, 27, 28, 29]
    # amount = 123123

    mySolution = Solution()
    print("答案如下：")
    print(mySolution.coinChange(coins, amount))
