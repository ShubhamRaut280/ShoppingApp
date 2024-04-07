import android.util.Log
import com.shubham.shoppingapp.Interfaces.ApiService
import com.shubham.shoppingapp.Interfaces.GenCallback
import com.shubham.shoppingapp.Models.ProductModel
import com.shubham.shoppingapp.Retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiRepository {
    companion object {
        fun getProducts(callback: GenCallback<List<ProductModel>>) {
            val productService = RetrofitClient.instance.create(ApiService::class.java)
            val call = productService.getApiProducts()

            call.enqueue(object : Callback<List<ProductModel>> {
                override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>) {
                    if (response.isSuccessful) {
                        val products = response.body()
                        callback.onSuccess(products ?: emptyList())
                    } else {
                        callback.onFailure("Failed to fetch products: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                    Log.d("product", "onFailure: failed to get products : " + t.message + t.localizedMessage + t)
                    callback.onFailure("Failed to fetch products: ${t.message}")
                }
            })
        }
    }
}
