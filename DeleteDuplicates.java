class DeleteDuplicates{
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = head, curr = head.next, after = curr.next;
        while(curr != null){
            if(curr.val == prev.val){
                prev.next = curr.next;
                curr = curr.next;
            }
            else {
                ListNode temp = curr;
                curr = curr.next;
                prev = temp;
            }
        }
        return head;
    }

    public class ListNode {											// Definition for singly-linked list.
		final int val;
		ListNode next = null;
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode prev) { this.val = val; prev.next = this; }
	}
    // ----------- TESTING ------------
    public ListNode makeList0(){										// ListNode = [] 
		return null;
	}
	public ListNode makeList1(){										// ListNode = [1]
		return new ListNode(1);
	}
    public ListNode makeList3(){										// ListNode = [1 2 3] 
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2,a);
		ListNode c = new ListNode(3,b);
		return a;
	}
    public ListNode makeList5(){										// ListNode = [1 1 2 3 3] 
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(1,a);
		ListNode c = new ListNode(2,b);
		ListNode d = new ListNode(3,c);
		ListNode e = new ListNode(3,d);
		return a;
	}
	public ListNode makeList6(){										// ListNode = [1 2 2 2 3 3] 
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2,a);
		ListNode c = new ListNode(2,b);
		ListNode d = new ListNode(2,c);
		ListNode e = new ListNode(3,d);
		ListNode f = new ListNode(3,e);
		return a;
	}
    public String print(final ListNode head){									// printing method of our singly-linked list
		String s = null;
		ListNode p = head;
		while(p != null){
			if( s == null) s = "" + p.val; else s += " " + p.val;
			p = p.next;
		}
		return s == null ? "" : s;
	}
    public static void test0(String ta){										
	    DeleteDuplicates s = new DeleteDuplicates();
	    ListNode head = s.makeList0();
	    String tb = "";
	    String rb = s.print(head);
	    assert(tb.equals(rb));
	    
	    ListNode r = s.deleteDuplicates(head);
	    String ra = s.print(r);
	    assert(ta.equals(ra));
	}
    public static void test1(String ta){										
	    DeleteDuplicates s = new DeleteDuplicates();
	    ListNode head = s.makeList1();
	    String tb = "1";
	    String rb = s.print(head);
	    assert(tb.equals(rb));
	    
	    ListNode r = s.deleteDuplicates(head);
	    String ra = s.print(r);
	    assert(ta.equals(ra));
	}
    public static void test3(String ta){										
	    DeleteDuplicates s = new DeleteDuplicates();
	    ListNode head = s.makeList3();
	    String tb = "1 2 3";
	    String rb = s.print(head);
	    assert(tb.equals(rb));
	    
	    ListNode r = s.deleteDuplicates(head);
	    String ra = s.print(r);
	    assert(ta.equals(ra));
    }
    public static void test5(String ta){										
	    DeleteDuplicates s = new DeleteDuplicates();
	    ListNode head = s.makeList5();
	    String tb = "1 1 2 3 3";
	    String rb = s.print(head);
	    assert(tb.equals(rb));

	    ListNode r = s.deleteDuplicates(head);
	    String ra = s.print(r);
	    assert(ta.equals(ra));
    }
    public static void test6(String ta){										
	    DeleteDuplicates s = new DeleteDuplicates();
	    ListNode head = s.makeList6();
	    String tb = "1 2 2 2 3 3";
	    String rb = s.print(head);
	    assert(tb.equals(rb));

	    ListNode r = s.deleteDuplicates(head);
	    String ra = s.print(r);
	    assert(ta.equals(ra));
    }
    public static void main(String args[]){
        test0("");
        test1("1");
        test3("1 2 3");
        test5("1 2 3");
        test6("1 2 3");
    }
}
