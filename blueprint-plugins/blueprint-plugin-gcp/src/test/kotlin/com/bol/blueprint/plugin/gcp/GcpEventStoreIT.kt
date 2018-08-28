package com.bol.blueprint.plugin.gcp

import com.bol.blueprint.domain.Event
import com.bol.blueprint.domain.Event.Companion.event
import com.bol.blueprint.domain.UntypedEvent
import com.bol.blueprint.store.EventQuery
import com.bol.blueprint.store.EventStore
import kotlinx.coroutines.experimental.runBlocking
import org.assertj.core.api.Assertions
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.time.Instant

@RunWith(SpringRunner::class)
@SpringBootTest
class GcpEventStoreIT {
    @Autowired
    private lateinit var eventStore: EventStore

    @After
    fun after() {
        (eventStore as GcpEventStore).deleteAll()
    }

    @Test
    fun `Can roundtrip events`() {
        runBlocking {
            eventStore.store(event(at(101)) { UntypedEvent(mapOf("foo" to "1")) })
            eventStore.store(event(at(102)) { UntypedEvent(mapOf("foo" to "2")) })
            eventStore.store(event(at(103)) { UntypedEvent(mapOf("foo" to "3")) })

            val (data, cursor) = eventStore.get(EventQuery(pageSize = 2))
            Assertions.assertThat(data).containsExactly(event(at(101)) { UntypedEvent(mapOf("foo" to "1")) }, event(at(102)) { UntypedEvent(mapOf("foo" to "2")) })

            val (data2, _) = eventStore.get(EventQuery(cursor = cursor))
            Assertions.assertThat(data2).containsExactly(event(at(103)) { UntypedEvent(mapOf("foo" to "3")) })
        }
    }

    private fun at(millis: Long) = Event.Metadata(timestamp = Instant.ofEpochMilli(millis))
}
