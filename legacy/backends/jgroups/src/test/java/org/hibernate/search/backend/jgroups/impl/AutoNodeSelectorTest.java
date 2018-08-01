/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.backend.jgroups.impl;

import java.io.DataInput;
import java.io.DataOutput;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.hibernate.search.testsupport.TestForIssue;
import org.jgroups.Address;
import org.jgroups.View;
import org.junit.Assert;
import org.junit.Test;

/**
 * JGroups' Auto Node Selector Test
 * <p>
 * Test if the selector choose a valid member
 *
 * @author Pedro Ruivo
 * @since 4.3
 */
@TestForIssue(jiraKey = "HSEARCH-1261")
public class AutoNodeSelectorTest {

	private static final String NEGATIVE_HASH_CODE_INDEX_NAME = "test.Book";
	private static final String POSITIVE_HASH_CODE_INDEX_NAME = "test.Author";
	private static final String ZERO_HASH_CODE_INDEX_NAME = "";

	private final AtomicInteger NEXT_ADDRESS_ID = new AtomicInteger( 0 );
	private final AtomicLong NEXT_VIEW_ID = new AtomicLong( 0 );

	@Test
	public void testIndexNameUsed() {
		Assert.assertTrue( NEGATIVE_HASH_CODE_INDEX_NAME.hashCode() < 0 );
		Assert.assertTrue( ZERO_HASH_CODE_INDEX_NAME.hashCode() == 0 );
		Assert.assertTrue( POSITIVE_HASH_CODE_INDEX_NAME.hashCode() > 0 );
	}

	@Test
	public void testNegativeHashCodeIndex() {
		performTest( NEGATIVE_HASH_CODE_INDEX_NAME );
	}

	@Test
	public void testPositiveHashCodeIndex() {
		performTest( POSITIVE_HASH_CODE_INDEX_NAME );
	}

	@Test
	public void testZeroHashCodeIndex() {
		performTest( ZERO_HASH_CODE_INDEX_NAME );
	}

	private void performTest(String index) {
		AutoNodeSelector selector = new AutoNodeSelector( index );

		/*
		 * there is 4 main cases:
		 * 1) when the view has 1 member;
		 * 2) when the view has 2 members;
		 * 3) when the view has 3 member
		 * 4) when the view has > 3 members;
		 *
		 * some view size can trigger the bug and other don't. test with a wide range
		 */

		for ( int viewSize = 1; viewSize <= 50; ++viewSize ) {
			View view = createView( viewSize );
			Assert.assertEquals( view.getMembers().size(), viewSize );
			selector.viewAccepted( view );
		}
	}

	private View createView(int size) {
		List<Address> addressList = new LinkedList<Address>();
		while ( size-- > 0 ) {
			addressList.add( new TestAddress( NEXT_ADDRESS_ID.incrementAndGet() ) );
		}
		return new View( addressList.get( 0 ), NEXT_VIEW_ID.incrementAndGet(), addressList );
	}

	private static final class TestAddress implements Address {

		private int addressId;

		public TestAddress(int addressId) {
			this.addressId = addressId;
		}

		@Override
		public int compareTo(Address o) {
			if ( o == null || !( o instanceof TestAddress ) ) {
				return -1;
			}
			return Integer.valueOf( addressId ).compareTo( ( (TestAddress) o ).addressId );
		}

		@Override
		public void writeTo(DataOutput dataOutput) throws Exception {
			dataOutput.writeInt( addressId );
		}

		@Override
		public void readFrom(DataInput dataInput) throws Exception {
			addressId = dataInput.readInt();
		}

		@Override
		public String toString() {
			return "TestAddress{" + "addressId=" + addressId + '}';
		}

		@Override
		public int serializedSize() {
			return 4;
		}
	}

}
