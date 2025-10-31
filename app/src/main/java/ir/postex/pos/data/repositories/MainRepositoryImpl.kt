package ir.postex.pos.data.repositories


import ir.postex.pos.data.source.remote.network.MainServices
import ir.postex.pos.data.source.remote.network.SafeApiRequest
import ir.postex.pos.domain.repositories.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mServices: MainServices
) : MainRepository, SafeApiRequest() {


//    override suspend fun getSubCategories(
//        advisorGroupId: String,
//        generalGroupSlug: String
//    ): Flow<Resource<GetSubCategoriesResponse>> =
//        apiRequest {
//            mServices.getSubCategories(advisorGroupId, generalGroupSlug)
//        }

}