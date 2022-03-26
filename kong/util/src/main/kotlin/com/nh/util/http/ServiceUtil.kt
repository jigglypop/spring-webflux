package com.nh.util.http

//import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
//import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.net.InetAddress
import java.net.UnknownHostException


@Component
@Configuration
public class ServiceUtil @Autowired constructor(
    @param:Value("\${server.port}") private val port: String
) {

    var serviceAddress: String = ""

    @Bean
    public fun getServiceFullAddress(): String {
        return if (serviceAddress != "") {
            serviceAddress
        } else {
            serviceAddress = findMyHostname() + "/" + findMyIpAddress() + ":" + port
            serviceAddress
        }
    }
    @Bean
    public fun findMyHostname(): String {
        return try {
            InetAddress.getLocalHost().hostName
        } catch (e: UnknownHostException) {
            "unknown host name"
        }
    }
    @Bean
    public fun findMyIpAddress(): String {
        return try {
            InetAddress.getLocalHost().hostAddress
        } catch (e: UnknownHostException) {
            "unknown IP address"
        }
    }

//    companion object {
//        private val LOG = LoggerFactory.getLogger(ServiceUtil::class.java)
//    }
}